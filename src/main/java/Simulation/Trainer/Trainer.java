package Simulation.Trainer;

import Simulation.Settings.Field;
import Simulation.Pokemon.Pokemon;
import Simulation.Settings.Map;

import java.util.ArrayList;
import java.util.Random;
public class Trainer {
    static Random rand = new Random();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static String nameOfPokemonsTrainer= "Ash";
    private static float trainersWinningBaseChance = 0.0f;
    private static float trainersCriticalHitBaseChance = 0.02f;
    private static String typeOfTrainersPokemon = "F";
    private int level;
    private int HowManyBattlesLost;
    private int HowManyPokemonsKilled;
    private static int HowManyPokemonsKilled2 = 0;
    private static int HowManyPokemonsCaught =0;
    private int Xposition = 0;
    private int Yposition = 0;
    static int chanceOfCatchingPokemon = 2;
    private static int expFor2Level = 3;
    private static int expFor3Level = 5;
    private static int expFor4Level = 7;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public Trainer(String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon) {
        Trainer.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        Trainer.trainersWinningBaseChance = trainersWinningBaseChance;
        Trainer.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        Trainer.typeOfTrainersPokemon = typeOfTrainersPokemon;
        level = 1;
        HowManyPokemonsKilled = 0;
        HowManyBattlesLost = 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void moveTrainer(Field[][] flatMap, ArrayList<Pokemon> arrayOfPokemons) {
        int[] pairOfXY = checkDistance(arrayOfPokemons);
        if ((pairOfXY[0] == this.getXposition() + 1 || pairOfXY[0] == this.getXposition() - 1) && (this.getYposition() - pairOfXY[1] < 2 && this.getYposition() - pairOfXY[1] > -2) || ((pairOfXY[1] == this.getYposition() - 1 || pairOfXY[1] == this.getYposition() + 1)) && (this.getXposition() - pairOfXY[0] < 2 && this.getXposition() - pairOfXY[0] > -2)) {
            flatMap[this.getYposition()][this.getXposition()].setOccupiedByTrainer(false);
            this.setXposition(pairOfXY[0]);
            this.setYposition(pairOfXY[1]);
            flatMap[this.getYposition()][this.getXposition()].setOccupiedByTrainer(true);
            if (flatMap[this.getYposition()][this.getXposition()].isOccupied()) {
                System.out.println("Trainer's fighting with another pokemon");
            }
        } else {
            int verticalMove;
            int horizontalMove;

            do {
                verticalMove = rand.nextInt(3) - 1;
                horizontalMove = rand.nextInt(3) - 1;
            }
            while (this.getXposition() + horizontalMove > Map.getW() - 1 || this.getXposition() + horizontalMove < 0 || this.getYposition() + verticalMove > Map.getH() - 1 || this.getYposition() + verticalMove < 0);

            flatMap[this.getYposition()][this.getXposition()].setOccupiedByTrainer(false);
            this.setXposition(this.getXposition() + horizontalMove);
            this.setYposition(this.getYposition() + verticalMove);
            flatMap[this.getYposition()][this.getXposition()].setOccupiedByTrainer(true);
        }
    }


     //checking trainer's distance to the nearest pokemon
     public int[] checkDistance(ArrayList<Pokemon> arrayOfPokemons) {
        int xForTrainer = this.getXposition();
        int yForTrainer = this.getYposition();
        int smallestDistance = Map.getH() * Map.getW();
        int xForSmallestDistance = 0;
        int yForSmallestDistance = 0;
        for (Pokemon pox : arrayOfPokemons) {
            if(smallestDistance > calculatingDistance(yForTrainer, xForTrainer, pox.getYposition(), pox.getXposition())) {
                smallestDistance = calculatingDistance(yForTrainer, xForTrainer, pox.getYposition(), pox.getXposition());
                xForSmallestDistance = pox.getXposition();
                yForSmallestDistance = pox.getYposition();
            }
        }
        return new int[] {xForSmallestDistance, yForSmallestDistance};
     }

    //calculating trainer's distance to the nearest pokemon
    public int calculatingDistance(int y, int x, int aimedY, int aimedX) {
        return (Math.abs(y - aimedY) + Math.abs(x - aimedX));
    }

    //method checking is pokemon is catched - true if is, false if is not
    public boolean catchPokemon(int levelOfPokemon){
        if(level > levelOfPokemon) {
            int chance = rand.nextInt(100)+1;
            HowManyPokemonsCaught++;
            if(chance <= getChanceOfCatchingPokemon()){
                HowManyPokemonsCaught++;
                return true;
            }
            return false;
        }
        return false;
    }

    //grating trainer experience
    public void giveExperience(int howMany) {
        setHowManyPokemonsKilled(getHowManyPokemonsKilled() + howMany);
    }

    //checking if level up's been earned
    public void levelUp() {
        if(getHowManyPokemonsKilled() >= expFor4Level) {
            setLevelOfPokemonTrainer(4);
        } else if (getHowManyPokemonsKilled() >= expFor3Level) {
            setLevelOfPokemonTrainer(3);
        } else if (getHowManyPokemonsKilled() >= expFor2Level) {
            setLevelOfPokemonTrainer(2);
        }

    }
    //method checking if the trainer should get a level up
    public boolean checkingProgress(){
        if (getHowManyBattlesLost() >= 3){
            //Defeat = true;
            System.out.println("Simulation ended. Trainer " + ANSI_RED + "lost" + ANSI_RESET + ".");
            return false;
        }
        if (getLevelOfPokemonTrainer() == 4){
            //WinByLevel = true;
            System.out.println("Simulation ended. Trainer "+ ANSI_GREEN +"won" +ANSI_RESET + ".");
            return false;
        }
        return true;
    }

    //method that states if trainer lost or won
    public boolean fight(int level, String typeOfEnemyPokemon, String typeOfEnemyPokemonsField, Field[][] flatMap) {
        float trainerWinningChance = (getTrainersWinningBaseChance() + getTrainersCriticalHitBaseChance()) * 100 +theDifferenceInPokemonType(typeOfEnemyPokemon) + theDifferenceInFieldType(flatMap, typeOfEnemyPokemonsField);
        float generatedNumberWhoWon = rand.nextFloat() * 100;
        if (generatedNumberWhoWon<=trainerWinningChance) return true;
        else return false;
    }

    //method checking the difference in pokemons' type for trainer's benefit or trainer's disadvantage
    public float theDifferenceInPokemonType(String pokemonType) {
        String fightingTrainersPokemonType = typeOfTrainersPokemon;

        if (fightingTrainersPokemonType.equals("F")) {
            if (pokemonType.equals("W")) {
                return -5;
            }
            if (pokemonType.equals("g")) {
                return 5;
            }
        }
        if (fightingTrainersPokemonType.equals("W")) {
            if (pokemonType.equals("G")) {
                return -5;
            }
            if (pokemonType.equals("F")) {
                return 5;
            }
        }
        if (fightingTrainersPokemonType.equals("G")) {
            if (pokemonType.equals("g")) {
                return -5;
            }
            if (pokemonType.equals("W")) {
                return 5;
            }
        }
        if (fightingTrainersPokemonType.equals("g")) {
            if (pokemonType.equals("F")) {
                return -5;
            }
            if (pokemonType.equals("G")) {
                return 5;
            }
        }
        return 0;
    }

    public float theDifferenceInFieldType(Field[][] flatMap, String PokemonFieldType) {
        String trainerFieldType = flatMap[this.getYposition()][this.getXposition()].getFieldType();
        String pokemonFieldType = PokemonFieldType;

        if (trainerFieldType.equals("F")) {
            if (pokemonFieldType.equals("W")) {
                return -5;
            }
            if (pokemonFieldType.equals("g")) {
                return 5;
            }
        }
        if (trainerFieldType.equals("W")) {
            if (pokemonFieldType.equals("G")) {
                return -5;
            }
            if (pokemonFieldType.equals("F")) {
                return 5;
            }
        }
        if (trainerFieldType.equals("G")) {
            if (pokemonFieldType.equals("g")) {
                return -5;
            }
            if (pokemonFieldType.equals("W")) {
                return 5;
            }
        }
        if (trainerFieldType.equals("g")) {
            if (pokemonFieldType.equals("F")) {
                return -5;
            }
            if (pokemonFieldType.equals("G")) {
                return 5;
            }
        }
        return 0;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static String getNameOfPokemonsTrainer() {return nameOfPokemonsTrainer;}
    public static void setNameOfPokemonsTrainer(String newNameOfPokemonsTrainer) { nameOfPokemonsTrainer = newNameOfPokemonsTrainer; }
    public static float getTrainersWinningBaseChance() { return trainersWinningBaseChance;}
    public static void setTrainersWinningBaseChance(float newTrainersWinningBaseChance) {trainersWinningBaseChance = newTrainersWinningBaseChance;}
    public static float getTrainersCriticalHitBaseChance() {return trainersCriticalHitBaseChance;}
    public static void setTrainersCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {trainersCriticalHitBaseChance = newTrainersCriticalHitBaseChance;}
    public static String getTypeOfTrainersPokemon() {return typeOfTrainersPokemon;}
    public static void setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {typeOfTrainersPokemon = newTypeOfTrainersPokemon;}
    public int getLevelOfPokemonTrainer() {return level;}
    public void setLevelOfPokemonTrainer(int level) { this.level=level;}
    public int getHowManyBattlesLost() { return HowManyBattlesLost;}
    public void setHowManyBattlesLost(int howManyBattlesLost) { HowManyBattlesLost = howManyBattlesLost;}
    public int getHowManyPokemonsKilled(){return HowManyPokemonsKilled;}
    public void setHowManyPokemonsKilled(int newHowManyPokemonsKilled){HowManyPokemonsKilled = newHowManyPokemonsKilled;}
    public int getXposition(){return Xposition;}
    public void setXposition(int newXposition){Xposition = newXposition;}
    public int getYposition(){return Yposition;}
    public void setYposition(int newYposition){Yposition = newYposition;}
    public static int getChanceOfCatchingPokemon() { return chanceOfCatchingPokemon;}
    public static void setChanceOfCatchingPokemon(int chanceOfCatchingPokemon) { Trainer.chanceOfCatchingPokemon = chanceOfCatchingPokemon;}
    public static int getExpFor2Level () {return expFor2Level;}
    public static void setExpFor2Level (int expFor2Level) {Trainer.expFor2Level=expFor2Level;}
    public static int getExpFor3Level () {return expFor3Level;}
    public static void setExpFor3Level (int expFor3Level) {Trainer.expFor3Level=expFor3Level;}
    public static int getExpFor4Level () {return expFor4Level;}
    public static void setExpFor4Level (int expFor4Level) {Trainer.expFor4Level=expFor4Level;}
    public static int getHowManyPokemonsCaught () {return HowManyPokemonsCaught;}
    //public static boolean getWinByLevel () {return WinByLevel;}
    //public static boolean getDefeat () {return Defeat;}
    public static int getHowManyPokemonsKilled2 () {return HowManyPokemonsKilled2;}
    public static void setHowManyPokemonsKilled2 (int HowManyPokemonsKilled2) {Trainer.HowManyPokemonsKilled2 = HowManyPokemonsKilled2;}
}

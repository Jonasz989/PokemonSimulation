package Simulation;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class Trainer {

    static Random rand = new Random();
    //trainer's id and level
    private static int ID = 0;
    public static int getIDofPokemonTrainer (){return ID;}


    private static int level = 1;
    public static int getLevelOfPokemonTrainer() {return level;}
    public static void setLevelOfPokemonTrainer(int level) {Trainer.level=level;}


    private int HowManyBattlesLost=0;
    public int getHowManyBattlesLost() {return HowManyBattlesLost;}
    public void setHowManyBattlesLost(int howManyBattlesLost) {HowManyBattlesLost = howManyBattlesLost;}



    //constructor for the trainer
    Trainer (String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon) {
        Trainer.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        Trainer.trainersWinningBaseChance = trainersWinningBaseChance;
        Trainer.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        Trainer.typeOfTrainersPokemon = typeOfTrainersPokemon;
        ID = 0;
        level = 1;
        HowManyPokemonsKilled = 0;
        HowManyBattlesLost = 0;

    }


    //variable, getter and setter for trainer's winning base chance
    private static float trainersWinningBaseChance = 1f;
    public static float getTrainersWinningBaseChance() {
        return trainersWinningBaseChance;
    }
    public static void setTrainersWinningBaseChance(float newTrainersWinningBaseChance) {trainersWinningBaseChance = newTrainersWinningBaseChance;}


    //variable, getter and setter for trainer's critical hit base chance
    private static float trainersCriticalHitBaseChance = 0.02f;
    public static float getTrainersCriticalHitBaseChance() {return trainersCriticalHitBaseChance;}
    public static void setTrainersCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {trainersCriticalHitBaseChance = newTrainersCriticalHitBaseChance;}


    //variable, getter and setter for trainer pokemon's type
    private static String typeOfTrainersPokemon="fire";
    public static String getTypeOfTrainersPokemon() {return typeOfTrainersPokemon;}
    public static void setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {typeOfTrainersPokemon = newTypeOfTrainersPokemon;}


    //variable, getter and setter for pokemons trainer's name
    private static String nameOfPokemonsTrainer= "Ash";
    public static String getNameOfPokemonsTrainer() {return nameOfPokemonsTrainer;}
    public static void setNameOfPokemonsTrainer(String newNameOfPokemonsTrainer) {nameOfPokemonsTrainer = newNameOfPokemonsTrainer;}


    //variable, getter and setter for how many pokemons trainer has killed so far
    private int HowManyPokemonsKilled = 0;
    public int getHowManyPokemonsKilled(){return HowManyPokemonsKilled;}
    public void setHowManyPokemonsKilled(int newHowManyPokemonsKilled){HowManyPokemonsKilled = newHowManyPokemonsKilled;}


    //variables, getters and setters for trainer's X and Y position
    private int Xposition = 0;
    public int getXposition(){return Xposition;}
    public void setXposition(int newXposition){Xposition = newXposition;}
    private int Yposition = 0;
    public int getYposition(){return Yposition;}
    public void setYposition(int newYposition){Yposition = newYposition;}


    //moving trainer through the map
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

    public static int getChanceOfCatchingPokemon() {
        return chanceOfCatchingPokemon;
    }

    public static void setChanceOfCatchingPokemon(int chanceOfCatchingPokemon) {
        Trainer.chanceOfCatchingPokemon = chanceOfCatchingPokemon;
    }
    static int chanceOfCatchingPokemon = 2;

    //method checking is pokemon is catched - true if is, false if is not
    public boolean catchPokemon(int levelOfPokemon){
        if(level > levelOfPokemon) {
            int chance = rand.nextInt(100)+1;
            if (chance <= getChanceOfCatchingPokemon()){
                return true;
            }
        }

        return false;
    }

    public void giveExperience(int howMany) {
        setHowManyPokemonsKilled(getHowManyPokemonsKilled() + howMany);
    }

    private static int expFor2Level = 3;
    public static int getExpFor2Level () {return expFor2Level;}
    public static void setExpFor2Level (int expFor2Level) {Trainer.expFor2Level=expFor2Level;}
    private static int expFor3Level = 5;
    public static int getExpFor3Level () {return expFor3Level;}
    public static void setExpFor3Level (int expFor3Level) {Trainer.expFor3Level=expFor3Level;}
    private static int expFor4Level = 7;
    public static int getExpFor4Level () {return expFor4Level;}
    public static void setExpFor4Level (int expFor4Level) {Trainer.expFor4Level=expFor4Level;}

    public void levelUp() {
        if(getHowManyPokemonsKilled() >= expFor4Level) {
            setLevelOfPokemonTrainer(4);
        } else if (getHowManyPokemonsKilled() >= expFor3Level) {
            setLevelOfPokemonTrainer(3);
        } else if (getHowManyPokemonsKilled() >= expFor2Level) {
            setLevelOfPokemonTrainer(2);
        }

    }

    //method checking if the trainer should get a level up, if he won or lost
    public boolean checkingProgress(){

        if (getHowManyBattlesLost() >= 3){
            System.out.println("Simulation ended. Trainer lost.");
            return false;
        }

        if (getLevelOfPokemonTrainer() == 4){
            System.out.println("Simulation ended. Trainer won.");
            return false;
        }
        return true;
    }

    public boolean fight(int level, String typeOfEnemyPokemon) {

        float trainerWinningChance = (getTrainersWinningBaseChance() + getTrainersCriticalHitBaseChance()) * 100;

        float generatedNumberWhoWon = rand.nextFloat() * 100;


        if(generatedNumberWhoWon <= trainerWinningChance) {
            return true;
        } else {
            return false;
        }
    }

    public float theDifferenceInPokemonType(Pokemon pox) {
        return 0;
    }

}

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


    private static int HowManyBattlesLost=0;
    public static int getHowManyBattlesLost() {return HowManyBattlesLost;}
    public static void setHowManyBattlesLost(int howManyBattlesLost) {HowManyBattlesLost = howManyBattlesLost;}



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
    private static float trainersWinningBaseChance = 0.5f;
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

    public void fightWithPokemon(Field[][] flatMap, ArrayList<Pokemon> arrayOfPokemons) {
        int zmiennaDoWalki = rand.nextInt(2);

        if (zmiennaDoWalki == 1) {
            //wygrana

        } else {
            //przegrana
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

    public boolean isPokemonClose(Field[][] flatMap) {
        int Xtrainer = this.getXposition();
        int Ytrainer = this.getYposition();

        for(int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if(flatMap[Ytrainer + i][Xtrainer + j].isOccupied()) {
                        return true;
                    }
                } catch (IndexOutOfBoundsException e) {
                }

            }
        }
        return false;
    }


    static int chanceOfCatchingPokemon = 2;
    //method checking is pokemon is catched - true if is, false if is not
    public boolean catchPokemon(int levelOfPokemon){
        if(level > levelOfPokemon) {
            int chance = rand.nextInt(100)+1;
            if (chance <= chanceOfCatchingPokemon){
                return true;
            }
        }

        return false;
    }


    //method checking if the trainer should get a level up, if he won or lost
    public boolean checkingProgress(){
        int level2 = 3;
        int level3 = 5;
        int level4 = 7;
        if (HowManyBattlesLost>=3){
            System.out.println("Simulation ended. Trainer lost.");
            return false;
        }
        if (getHowManyPokemonsKilled()>=level2) setLevelOfPokemonTrainer(2);
        if (getHowManyPokemonsKilled()>=level3) setLevelOfPokemonTrainer(3);
        if (this.getHowManyPokemonsKilled()>=level4){
            System.out.println("Simulation ended. Trainer won.");
            return false;
        }
        return true;
    }

    /*public boolean fight(Field[][] flatMap, Trainer trainer, ArrayList<Pokemon> arrayOfPokemons) {

        float trainerWinningChance = this.getTrainersWinningBaseChance() + this.getTrainersCriticalHitBaseChance() - Pokemon.getPokemonsCriticalHitBaseChance() + Pokemon.theDifferenceInLevels(Trainer.getLevelOfPokemonTrainer(), Simulation.getLevelOfDeletedPokemon()) +Pokemon.theDifferenceInPokemonType(trainer);

        float generatedNumberWhoWon = rand.nextFloat() * 100;


        if(generatedNumberWhoWon <= trainerWinningChance) {
            //trener wygryw
            trainer.setHowManyPokemonsKilled(trainer.getHowManyPokemonsKilled()+1);
            trainer.checkingProgress();
            return true;
        } else {
            //pokemon wygrywa
            trainer.setHowManyBattlesLost(trainer.getHowManyBattlesLost()+1);
            trainer.checkingProgress();
            return false;
        }
        */
}

package Simulation;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
public class Trainer {

    static Random rand = new Random();

    Trainer (String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon) {
        this.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        this.trainersWinningBaseChance = trainersWinningBaseChance;
        this.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        this.typeOfTrainersPokemon = typeOfTrainersPokemon;
        this.ID = 0;
        this.level = 1;
        this.HowManyPokemonsKilled = 0;
        int Xposition;
        int Yposition;
    }

    //variable for Base Winning Chance for the trainer, getter and setter for it as well
    private static float trainersWinningBaseChance = 0.5f;
    public static float getTrainersWinningBaseChance() {
        return trainersWinningBaseChance;
    }
    public static void setTrainersWinningBaseChance(float newTrainersWinningBaseChance) {
        trainersWinningBaseChance = newTrainersWinningBaseChance;
    }

    //variable for Base Critical Hit Chance for the trainer, getter and setter for it as well
    private static float trainersCriticalHitBaseChance = 0.02f;

    public static float getTrainersCriticalHitBaseChance() {
        return trainersCriticalHitBaseChance;
    }

    public static void setTrainersCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {
        trainersCriticalHitBaseChance = newTrainersCriticalHitBaseChance;
    }

    //variable for Type of Trainer's Pokemon, getter and setter for it as well
    private static String typeOfTrainersPokemon="fire";
    public static String getTypeOfTrainersPokemon() {
        return typeOfTrainersPokemon;
    }
    public static void setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {
        typeOfTrainersPokemon = newTypeOfTrainersPokemon;
    }
    //variable for pokemons trainer name, getter and setter for it as well
    private static String nameOfPokemonsTrainer= "Ash";
    public static String getNameOfPokemonsTrainer() {
        return nameOfPokemonsTrainer;
    }
    public static void setNameOfPokemonsTrainer(String newNameOfPokemonsTrainer) {
        nameOfPokemonsTrainer = newNameOfPokemonsTrainer;
    }

    private static int ID = 0;
    public static int getIDofPokemonTrainer (){return ID;}

    private static int level = 0;
    public static int getLevelOfPokemonTrainer (){return level;}

    private int HowManyPokemonsKilled = 0;
    public int getHowManyPokemonsKilled(){
        return HowManyPokemonsKilled;
    }
    public void setHowManyPokemonsKilled(int newHowManyPokemonsKilled){
        HowManyPokemonsKilled = newHowManyPokemonsKilled;
    }

    private int Xposition = 0;
    public int getXposition(){return Xposition;}

    public void setXposition(int newXposition){
        Xposition = newXposition;
    }

    private int Yposition = 0;
    public int getYposition(){return Yposition;}

    public void setYposition(int newYposition){
        Yposition = newYposition;
    }

    public void moveTrainer(Field[][] flatMap, Trainer trainer, ArrayList<Pokemon> arrayOfPokemons) {
        int[] pairOfXY = checkDistance(trainer, arrayOfPokemons);
        if (pairOfXY[0] == this.getXposition() + 1 || pairOfXY[0] == this.getXposition() - 1 || pairOfXY[1] == this.getXposition() - 1 || pairOfXY[1] == this.getXposition() + 1) {
            flatMap[this.getXposition()][this.getYposition()].setOccupiedByTrainer(false);
            this.setXposition(pairOfXY[0]);
            this.setYposition(pairOfXY[1]);
            flatMap[this.getXposition()][this.getYposition()].setOccupiedByTrainer(true);
            if (flatMap[this.getXposition()][this.getYposition()].isOccupied) {
                System.out.println("NAPIERDALAMY SIE");
            }
        }
    }

     public int[] checkDistance(Trainer trainer, ArrayList<Pokemon> arrayOfPokemons) {
        int xForTrainer = trainer.getXposition();
        int yForTrainer = trainer.getYposition();
        int smallestDistance = Map.getH() + Map.getW();
        int xForSmallestDistance = 0;
        int yForSmallestDistance = 0;
        for (Pokemon pox : arrayOfPokemons) {
            if(smallestDistance > calculatingDistance(yForTrainer, xForTrainer, pox.getYposition(), pox.getXposition())) {
                smallestDistance = (int) calculatingDistance(yForTrainer, xForTrainer, pox.getYposition(), pox.getXposition());
                xForSmallestDistance = pox.getXposition();
                yForSmallestDistance = pox.getYposition();
            }
        }
        return new int[] {xForSmallestDistance, yForSmallestDistance};
     }

     public double calculatingDistance(int y, int x, int aimedY, int aimedX) {
        return Math.sqrt(Math.pow((Math.abs(y-aimedY)), 2) + Math.pow((Math.abs(x-aimedX)), 2));
     }

}
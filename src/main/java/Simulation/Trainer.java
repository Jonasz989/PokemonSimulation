package Simulation;
import java.util.ArrayList;
import java.util.Random;
public class Trainer {

    static Random rand = new Random();

    Trainer (String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon, int ID, int level, int HowManyPokemonsKilled, int Xposition, int Yposition) {
        this.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        this.trainersWinningBaseChance = trainersWinningBaseChance;
        this.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        this.typeOfTrainersPokemon = typeOfTrainersPokemon;
        this.ID=ID;
        this.level=level;
        this.HowManyPokemonsKilled=HowManyPokemonsKilled;
        this.Xposition=Xposition;
        this.Yposition=Yposition;
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
    public static int getLevelofPokemonTrainer (){return level;}

    private static int HowManyPokemonsKilled = 0;
    public static int getHowManyPokemonsKilled(){
        return HowManyPokemonsKilled;
    }
    public static void setHowManyPokemonsKilled(int newHowManyPokemonsKilled){
        HowManyPokemonsKilled = newHowManyPokemonsKilled;
    }

    private static int Xposition = 0;
    public static int getXposition(){return Xposition;}

    public static void setXposition(int newXposition){
        Xposition = newXposition;
    }

    private static int Yposition = 0;
    public static int getYposition(){return Yposition;}

    public static void setYposition(int newYposition){
        Yposition = newYposition;
    }






    public void killingPokemon() {
        for (Pokemon pokemon : Simulation.arrayOfPokemons) {
            if(pokemon.getXposition()==Trainer.getXposition() && pokemon.getYposition()==Trainer.getYposition()){
                pokemon.setXposition(-1);
                pokemon.setYposition(-1);
            }
        }
        Trainer.setHowManyPokemonsKilled(Trainer.getHowManyPokemonsKilled()+1);
    }

    /*int howManyPokemonsKilledFor2Level = 2;
    public void levelUp2() {
        trainer.level=2;
    }
    int howManyPokemonsKilledFor3Level = 4;
    public void levelUp3 (){
        trainer.level=3;
    }*/


}









    /*public void movingTrainerThroughTheMap(Field[][] flatMap){
        //1-right, 2-left, 3-top, 4-bottom
        int[]directions = {1,2,3,4};
        int generateDirection = rand.nextInt(directions.length + 1);
        switch (generateDirection){
            case 1:
                if (Trainer.getXposition()<Map.getW()) {
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                    Trainer.setXposition(Trainer.getXposition() + 1);
                    if(flatMap[Trainer.getYposition()][Trainer.getXposition()].isOccupied()) {
                        if (!fight()) {
                            flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                            flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupied(false);
                            //kasujemy poka
                        }
                        else{
                            Trainer.setXposition(Trainer.getXposition() -1);
                            flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                        }
                    }
                    else{
                        flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                    }
                }
            case 2:
                if (Trainer.getXposition()>0 && !flatMap[Trainer.getYposition()][Trainer.getXposition()-1].isOccupied()){
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                    Trainer.setXposition(Trainer.getXposition()-1);
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                }
            case 3:
                if (Trainer.getYposition()>0 && !flatMap[Trainer.getYposition()-1][Trainer.getXposition()].isOccupied()){
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                    Trainer.setYposition(Trainer.getYposition()-1);
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                }
            case 4:
                if (Trainer.getYposition()<Map.getH() && !flatMap[Trainer.getYposition()+1][Trainer.getXposition()].isOccupied()){
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                    Trainer.setYposition(Trainer.getYposition()+1);
                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(true);
                }
        }
    }*/
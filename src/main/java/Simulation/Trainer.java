package Simulation;

public class Trainer {

    Trainer (String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon) {
        this.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        this.trainersWinningBaseChance = trainersWinningBaseChance;
        this.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        this.typeOfTrainersPokemon = typeOfTrainersPokemon;
    }

    //variable for Base Winning Chance for the trainer, getter and setter for it as well
    private static float trainersWinningBaseChance = 0;
    private float newTrainersWinningBaseChance = 0;
    public static float getTrainersWinningBaseChance() {
        return trainersWinningBaseChance;
    }
    public float setTrainersWinningBaseChance(float newTrainersWinningBaseChance) {
        return trainersWinningBaseChance = newTrainersWinningBaseChance;
    }

    //variable for Base Critical Hit Chance for the trainer, getter and setter for it as well
    private static float trainersCriticalHitBaseChance = 0;
    private float newTrainersCriticalHitBaseChance = 0;

    public static float getTrainersCriticalHitBaseChance() {
        return trainersCriticalHitBaseChance;
    }

    public float setTrainersCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {
        return trainersCriticalHitBaseChance = newTrainersCriticalHitBaseChance;
    }

    //variable for Type of Trainer's Pokemon, getter and setter for it as well
    private static String typeOfTrainersPokemon="fire";
    private String newTypeOfTrainersPokemon=" ";
    public static String getTypeOfTrainersPokemon() {
        return typeOfTrainersPokemon;
    }
    public static String setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {
        return typeOfTrainersPokemon = newTypeOfTrainersPokemon;
    }
    //variable for pokemons trainer name, getter and setter for it as well
    private String nameOfPokemonsTrainer= " ", newNameOfPokemonsTrainer = " ";
    public String getNameOfPokemonsTrainer() {
        return nameOfPokemonsTrainer;
    }
    public String setNameOfPokemonsTrainer(String newNameOfPokemonsTrainer) {
        return nameOfPokemonsTrainer = newNameOfPokemonsTrainer;
    }

}


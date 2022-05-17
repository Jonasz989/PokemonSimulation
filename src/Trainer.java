public class Trainer extends Map {

    Trainer (String nameOfPokemonsTrainer, float trainersWinningBaseChance, float trainersCriticalHitBaseChance, String typeOfTrainersPokemon) {
        this.nameOfPokemonsTrainer = nameOfPokemonsTrainer;
        this.trainersWinningBaseChance = trainersWinningBaseChance;
        this.trainersCriticalHitBaseChance = trainersCriticalHitBaseChance;
        this.typeOfTrainersPokemon = typeOfTrainersPokemon;
    }

    //variable for Base Winning Chance for the trainer, getter and setter for it as well
    private float trainersWinningBaseChance = 0, newTrainersWinningBaseChance = 0;
    public float getTrainersWinningBaseChance() {
        return trainersWinningBaseChance;
    }
    public float setTrainersWinningBaseChance(float newTrainersWinningBaseChance) {
        return trainersWinningBaseChance = newTrainersWinningBaseChance;
    }

    //variable for Base Critical Hit Chance for the trainer, getter and setter for it as well
    private float trainersCriticalHitBaseChance = 0, newTrainersCriticalHitBaseChance = 0;

    public float getTrainersCriticalHitBaseChance() {
        return trainersCriticalHitBaseChance;
    }

    public float setTrainersCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {
        return trainersCriticalHitBaseChance = newTrainersCriticalHitBaseChance;
    }

    //variable for Type of Trainer's Pokemon, getter and setter for it as well
    private String typeOfTrainersPokemon="fire", newTypeOfTrainersPokemon=" ";
    public String getTypeOfTrainersPokemon() {
        return typeOfTrainersPokemon;
    }
    public String setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {
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

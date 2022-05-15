import java.util.Scanner;

public class Settings {

    Scanner scanner = new Scanner(System.in);

    //variables for H=height of the map, W=width of the map and getters and setters for them as well
    private int H = 0, W = 0, newH = 0, newW = 0;

    public int getH() {
        return H;
    }
    public int getW() {
        return W;
    }
    public int setH(int newH) {
        return H = newH;
    }
    public int setW(int newW) {
        return H = newW;
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

    //variable for Base Critical Hit Chance for the other pokemons, getter and setter for it as well
    float pokemonsCriticalHitBaseChance = 0, newPokemonsCriticalHitBaseChance=0;
    public float getPokemonsCriticalHitBaseChance() {
        return pokemonsCriticalHitBaseChance;
    }

    public float setPokemonsCriticalHitBaseChance(float newTrainersCriticalHitBaseChance) {
        return pokemonsCriticalHitBaseChance = newPokemonsCriticalHitBaseChance;
    }


    //variable for Type of Trainer's Pokemon, getter and setter for it as well
    String TypeOfTrainersPokemon="fire", newTypeOfTrainersPokemon=" ";
    public String getTypeOfTrainersPokemon() {
        return TypeOfTrainersPokemon;
    }
    public String setTypeOfTrainersPokemon(String newTypeOfTrainersPokemon) {
        return TypeOfTrainersPokemon = newTypeOfTrainersPokemon;
    }

    //variable for the count of pokemons on the map, getter and setter for it as well
    int CountOfPokemonOnTheMap = 0, newCountOfPokemonOnTheMap=0;
    public int getCountOfPokemonOnTheMap(){
        return CountOfPokemonOnTheMap;
    }
    public int setCountOfPokemonOnTheMap(int newCountOfPokemonOnTheMap){
        return CountOfPokemonOnTheMap = newCountOfPokemonOnTheMap;
    }
    //variable for the count of water type pokemons on the map, getter and setter for it as well
    int WaterPokemonsOnTheMap = 0, newWaterPokemonsOnTheMap = 0;
    public int getWaterPokemonsOnTheMap() {
        return WaterPokemonsOnTheMap;
    }
    public int setWaterPokemonsOnTheMap(int newWaterPokemonsOnTheMap) {
        return WaterPokemonsOnTheMap = newWaterPokemonsOnTheMap;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    int FirePokemonsOnTheMap = 0, newFirePokemonsOnTheMap = 0;
    public int getFirePokemonsOnTheMap(){
        return FirePokemonsOnTheMap;
    }
    public int setFirePokemonsOnTheMap(int newFirePokemonsOnTheMap){
        return FirePokemonsOnTheMap = newFirePokemonsOnTheMap;
    }


    //variable for the count of ground type pokemons on the map, getter and setter for it as well
    int GroundPokemonsOnTheMap = 0, newGroundPokemonsOnTheMap = 0;
    public int getGroundPokemonsOnTheMap() {
        return GroundPokemonsOnTheMap;
    }
    public int setGroundPokemonsOnTheMap(int newGroundPokemonsOnTheMap) {
        return GroundPokemonsOnTheMap = newGroundPokemonsOnTheMap;
    }
    //variable for the count of grass type pokemons on the map, getter and setter for it as well
    int GrassPokemonsOnTheMap = 0, newGrassPokemonsOnTheMap = 0;

    //variable for the count of water type fields on the map, getter and setter for it as well
    int WaterFieldsOnTheMap = 0, newWaterFieldsOnTheMap = 0;
    public int getWaterFieldsOnTheMap() {
        return WaterFieldsOnTheMap;
    }
    public int setWaterFieldsOnTheMap(int newWaterFieldsOnTheMap) {
        return WaterFieldsOnTheMap = newWaterFieldsOnTheMap;
    }
    //variable for the count of fire type fields on the map, getter and setter for it as well
    int FireFieldsOnTheMap = 0, newFireFieldsOnTheMap = 0;
    public int getFireFieldsOnTheMap() {
        return FireFieldsOnTheMap;
    }
    public int setFireFieldsOnTheMap(int newFireFieldsOnTheMap) {
        return FireFieldsOnTheMap = newFireFieldsOnTheMap;
    }
    //variable for the count of ground type fields on the map, getter and setter for it as well
    int GroundFieldsOnTheMap = 0, newGroundFieldsOnTheMap = 0;
    public int getGroundFieldsOnTheMap() {
        return GroundFieldsOnTheMap;
    }
    public int setGroundFieldsOnTheMap(int newGroundFieldsOnTheMap) {
        return GroundFieldsOnTheMap = newGroundFieldsOnTheMap;
    }
    //variable for the count of grass type fields on the map, getter and setter for it as well
    int GrassFieldsOnTheMap = 0, newGrassFieldsOnTheMap = 0;
    public int getGrassFieldsOnTheMap() {
        return GrassFieldsOnTheMap;
    }
    public int setGrassFieldsOnTheMap(int newGrassFieldsOnTheMap) {
        return GrassFieldsOnTheMap = newGrassFieldsOnTheMap;
    }


    /**
     * Printing current settings to user
     */
    public void printSettings() {

        System.out.println("1. Size of the map: "+ getH() + "x" +getW());
        System.out.println("2. Special fields: ");
        System.out.println("- Fire Type: "+getFireFieldsOnTheMap());
        System.out.println("- Water Type: "+getWaterFieldsOnTheMap());
        System.out.println("- Ground Type: "+getGroundFieldsOnTheMap());
        System.out.println("- Grass Type: "+getGrassFieldsOnTheMap());
        System.out.println("3. Type of trainer's pokemon: " +getTypeOfTrainersPokemon());
        System.out.println("4. Count of pokemons on the map: "+getCountOfPokemonOnTheMap());
        System.out.println("5. Types of pokemons on the map: ");
        System.out.println("- Fire Type: "+getFirePokemonsOnTheMap());
        System.out.println("- Water Type: "+getWaterPokemonsOnTheMap());
        System.out.println("- Ground Type: "+getGroundPokemonsOnTheMap());
        System.out.println("- Grass Type: "+getGrassFieldsOnTheMap());
        System.out.println("6. Trainer's pokemon's base chance of winning: "+getTrainersWinningBaseChance());
        System.out.println("7. Trainer's pokemon's base chance of derivation of critical hit: "+getTrainersCriticalHitBaseChance());
        System.out.println("8. Pokemons' base chance of derivation of critical hit: "+getPokemonsCriticalHitBaseChance());
        System.out.println("9. Type of saving the results: ");
        System.out.println("Press enter to continue ");

    }

    /**
     * Method that show us menu to changing settings to our simulation
     */
    public void changeSettings() {
        while(true) {
            int choiceInSettings;
            System.out.println("Choose which settings you want to change");
            System.out.println("1. Map");
            System.out.println("2. Trainer");
            System.out.println("3. Pokemon's");
            System.out.println("4. Chances");
            System.out.println("5. Saving options");
            System.out.println("6. Exit");

            choiceInSettings = scanner.nextInt();
            switch(choiceInSettings) {
                case 1:
                    changeMapSettings();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Your input was invalid. Please choose number between 1-6.");
                    break;
            }
        }
    }

    /**
     * Method for changing map setting
     */
    public void changeMapSettings() {
        int choice;
        while(true) {
        System.out.println("Choose which setting you want to change");
        System.out.println("1. Size of the map");
        System.out.println("2. % chance of generating pool");
        System.out.println("3. Exit");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Current height is " + getH() + ".");
                System.out.println("Type your new height: ");
                newH = scanner.nextInt();
                setH(newH);
                System.out.println("Current width is " + getW() + ".");
                System.out.println("Type your new width: ");
                newW = scanner.nextInt();
                setW(newW);
                break;
            case 2:
                while (true) {
                    System.out.println("Select what type of field you want to change.");
                    System.out.println("1. Fire");
                    System.out.println("2. Water");
                    System.out.println("3. Ground");
                    System.out.println("4. Grass");
                    System.out.println("5. Exit");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Current chance of generating fire pool is" + getFireFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            newFireFieldsOnTheMap = scanner.nextInt();
                            setFireFieldsOnTheMap(newFireFieldsOnTheMap);
                            break;
                        case 2:
                            System.out.println("Current chance of generating water pool is" + getWaterFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            newWaterFieldsOnTheMap = scanner.nextInt();
                            setWaterFieldsOnTheMap(newWaterFieldsOnTheMap);
                            break;
                        case 3:
                            System.out.println("Current chance of generating ground pool is" + getGroundFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            newGroundFieldsOnTheMap = scanner.nextInt();
                            setGroundFieldsOnTheMap(newGroundFieldsOnTheMap);
                            break;
                        case 4:
                            System.out.println("Current chance of generating grass pool is" + getGrassFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            newGrassFieldsOnTheMap = scanner.nextInt();
                            setGrassFieldsOnTheMap(newGrassFieldsOnTheMap);
                            break;
                        case 5:
                            System.out.println("Returning to map settings");
                            changeMapSettings();
                        default:
                            System.out.println("Your input was invalid. Please choose number between 1-5.");
                            continue;
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("Returning to the settings menu");
                changeSettings();
            default:
                System.out.println("Your input was invalid. Please choose number between 1-4.");
                continue;
            }
        }
    }






    public void changeTrainersWinningBaseChance() {
        int choice;
        choice =scanner.nextInt();
        //tutaj bedzie setter
    }
    public void changeTrainersCriticalHitBaseChance() {
        int choice;
        choice =scanner.nextInt();
        //tutaj bedzie setter
    }
    public void changeTypeOfTrainersPokemon() {
        int choice;
        while (true) {
            System.out.println("You may choose type of the trainer's pokemon from: ");
            System.out.println("1. Fire");
            System.out.println("2. Water");
            System.out.println("3. Ground");
            System.out.println("4. Grass");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch (choice) {
            case 1:
                //setter do fire
                break;
            case 2:
                //setter do water
                break;
            case 3:
                //setter do ground
                break;
            case 4:
                //setter do grass
                break;
            case 5:
                System.out.println("Returning to the settings menu");
                break;
            default:
                System.out.println("Your input was invalid. Please choose number between 1-5.");
                continue;
            }
        }
    }

}

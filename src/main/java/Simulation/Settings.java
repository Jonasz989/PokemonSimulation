package Simulation;

import java.util.Scanner;


public class Settings{

    //initialization of trainer object and giving the trainer default values

    static Scanner scanner = new Scanner(System.in);


    /**
     * Printing current settings to user
     */
    public static void printSettings() {

        System.out.println("1. Pokemons trainer's name: "+ Trainer.getNameOfPokemonsTrainer());
        System.out.println("2. Size of the map: "+ Map.getH() + "x" + Map.getW());
        System.out.println("3. Special fields: ");
        System.out.println("- Fire Type: " + Map.getFireFieldsOnTheMap());
        System.out.println("- Water Type: " + Map.getWaterFieldsOnTheMap());
        System.out.println("- Ground Type: " + Map.getGroundFieldsOnTheMap());
        System.out.println("- Grass Type: " + Map.getGrassFieldsOnTheMap());
        System.out.println("4. Type of trainer's pokemon: " + Trainer.getTypeOfTrainersPokemon());
        System.out.println("5. Count of pokemons on the map: "+ Pokemon.getCountOfPokemonOnTheMap());
        System.out.println("6. Types of pokemons on the map: ");
        System.out.println("- Fire Type: " + PokemonFire.getFirePokemonsOnTheMap());
        System.out.println("- Water Type: " + PokemonWater.getWaterPokemonsOnTheMap());
        System.out.println("- Ground Type: " + PokemonGround.getGroundPokemonsOnTheMap());
        System.out.println("- Grass Type: " + PokemonGrass.getGrassPokemonsOnTheMap());
        System.out.println("7. Trainer's pokemon's base chance of winning: " + Trainer.getTrainersWinningBaseChance());
        System.out.println("8. Trainer's pokemon's base chance of derivation of critical hit: " + Trainer.getTrainersCriticalHitBaseChance());
        System.out.println("9. Pokemons' base chance of derivation of critical hit: " + Pokemon.getPokemonsCriticalHitBaseChance());
        System.out.println("10. Type of saving the results: work in progress");
        System.out.println("Press enter to continue ");

    }

    /**
     * Method that show us menu to changing settings to our simulation
     */
    public static int changeSettings() {
        while(true) {
            int choiceInSettings;

            while(true){
                System.out.println("Choose which settings you want to change");
                System.out.println("1. Map");
                System.out.println("2. Trainer's");
                System.out.println("3. Pokemons'");
                System.out.println("4. Saving options");
                System.out.println("0. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();
            }
            switch(choiceInSettings) {
                case 1:
                    Settings.changeMapSettings();
                    break;
                case 2:
                    Settings.changeTrainersSettings();
                    break;
                case 3:
                    Settings.changePokemonsSettings();
                    break;
                case 4:
                    System.out.println("Not done yet.");
                    //tutaj bedzie ta funkcja ale napiszemy po wykladzie mrozona dopiero
                    break;
                case 0:
                    System.out.println("Going back to main menu");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose a number between 0-4.");
                    break;
            }
        }
    }

    /**
     * Method for changing map setting
     */
    public static int changeMapSettings() {
        int choiceInMapSettings;
        while(true) {
            while(true){
                System.out.println("Choose which setting you want to change");
                System.out.println("1. Size of the map");
                System.out.println("2. % chance of generating pool");
                System.out.println("0. Exit");
                boolean isOutputProper = scanner.hasNextInt();
                if(isOutputProper){
                    choiceInMapSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();

            }
            switch (choiceInMapSettings) {
                case 1:
                    changeSizeOfTheMap();
                    break;
                case 2:
                    changeFieldSettings();
                    break;
                case 0:
                    System.out.println("Returning to the settings menu");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-2.");
                    break;
            }
        }
    }

    //METHODS FOR MAP SETTINGS/////////////////////////////////////////////////////////////////////////////////////////

    static void changeSizeOfTheMap() {
        System.out.println("Current height is " + Map.getH() + ".");
        System.out.println("Type your new height: ");
        int newH = scanner.nextInt();
        Map.setH(newH);
        System.out.println("Current width is " + Map.getW() + ".");
        System.out.println("Type your new width: ");
        int newW = scanner.nextInt();
        Map.setW(newW);
    }


    static int changeFieldSettings() {
        while (true) {
            int choiceInPoolSettings;
            while(true){
                System.out.println("Select what type of field you want to change.");
                System.out.println("1. Fire");
                System.out.println("2. Water");
                System.out.println("3. Ground");
                System.out.println("4. Grass");
                System.out.println("0. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInPoolSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();
            }
            switch (choiceInPoolSettings) {
                case 1:
                    changeChanceOfGeneratingFireField();
                    break;
                case 2:
                    changeChanceOfGeneratingWaterPool();
                    break;
                case 3:
                    changeChanceOfGeneratingGroundPool();
                    break;
                case 4:
                    changeChanceOfGeneratingGrassPool();
                    break;
                case 0:
                    System.out.println("Returning to map settings");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose a number between 0-4.");
                    break;
            }
        }
    }

    static void changeChanceOfGeneratingFireField() {
        System.out.println("Current chance of generating fire pool is" + Map. getFireFieldsOnTheMap());
        System.out.println("Type new chance: ");
        int newFireFieldsOnTheMap = scanner.nextInt();
        Map.setFireFieldsOnTheMap(newFireFieldsOnTheMap);
    }

    static void changeChanceOfGeneratingWaterPool() {
        System.out.println("Current chance of generating water pool is" + Map.getWaterFieldsOnTheMap());
        System.out.println("Type new chance: ");
        int newWaterFieldsOnTheMap = scanner.nextInt();
        Map.setWaterFieldsOnTheMap(newWaterFieldsOnTheMap);
    }

    static void changeChanceOfGeneratingGroundPool() {
        System.out.println("Current chance of generating ground pool is" + Map.getGroundFieldsOnTheMap());
        System.out.println("Type new chance: ");
        int newGroundFieldsOnTheMap = scanner.nextInt();
        Map.setGroundFieldsOnTheMap(newGroundFieldsOnTheMap);
    }

    static void changeChanceOfGeneratingGrassPool() {
        System.out.println("Current chance of generating grass pool is" + Map.getGrassFieldsOnTheMap());
        System.out.println("Type new chance: ");
        int newGrassFieldsOnTheMap = scanner.nextInt();
        Map.setGrassFieldsOnTheMap(newGrassFieldsOnTheMap);
    }

    //END OF METHODS FOR MAP SETTINGS/////////////////////////////////////////////////////////////////////////////////////////

    //changing trainers settings

    public static int changeTrainersSettings() {
        while (true) {

            int choiceInTrainersSettings = 0;

            while(true){
                System.out.println("Which trainer's settings would you like to change: ");
                System.out.println("1. Trainer's name");
                System.out.println("2. Trainer's pokemon type");
                System.out.println("3. Trainer's winning base chance");
                System.out.println("4. Trainer's critical hit base chance");
                System.out.println("0. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInTrainersSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();

            }


            switch (choiceInTrainersSettings) {
                case 1:
                    changePokemonsTrainersName();
                    break;
                case 2:
                    changeTypeOfTrainersPokemon();
                    break;
                case 3:
                    changeTrainersWinningBaseChance();
                    break;
                case 4:
                    changeTrainersCriticalHitBaseChance();
                    break;
                case 0:
                    System.out.println("Leaving");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-4.");
                    break;
            }
        }
    }
    //METHODS FOR TRAINERS SETTING//////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void changePokemonsTrainersName(){
        while(true){
            System.out.println("To which name would you like to change it?: ");
            String choice;
            boolean test = scanner.hasNext();
            if(test){
                choice = scanner.next();
                Trainer.setNameOfPokemonsTrainer(choice);
                break;}
            else{
                System.out.println("You've entered something else rather than a String so please try again.");
            }
        }
    }

    public static void changeTrainersWinningBaseChance() {
        float choice;
        choice = scanner.nextInt();
        Trainer.setTrainersWinningBaseChance(choice);
    }
    public static void changeTrainersCriticalHitBaseChance() {
        float choice;
        choice = scanner.nextInt();
        Trainer.setTrainersCriticalHitBaseChance(choice);
    }
    public void changeHowMAnyPokemonsShouldBeOnTheMap(){
        System.out.println("How many should be then?");
        int choice = scanner.nextInt();


    }

    public static int changeTypeOfTrainersPokemon() {
        int choice;
        while (true) {
            while(true){
                System.out.println("You may choose type of the trainer's pokemon from: ");
                System.out.println("1. Fire");
                System.out.println("2. Water");
                System.out.println("3. Ground");
                System.out.println("4. Grass");
                System.out.println("0. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choice = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    Trainer.setTypeOfTrainersPokemon("fire");
                    return 0;
                case 2:
                    Trainer.setTypeOfTrainersPokemon("water");
                    return 0;
                case 3:
                    Trainer.setTypeOfTrainersPokemon("ground");
                    return 0;
                case 4:
                    Trainer.setTypeOfTrainersPokemon("grass");
                    return 0;
                case 0:
                    System.out.println("Returning to the settings menu");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-4.");
                    break;
            }
        }
    }

    //END OF METHODS FOR POKEMONS SETTINGS///////////////////////////////////////////////////////////////////////////////////////////////////


    public static int changePokemonsSettings() {
        while (true) {

            int choiceInPokemonsSettings = 0;
            while(true){
                System.out.println("Which pokemons' settings would you like to change: ");
                System.out.println("1. Pokemons count on the map");
                System.out.println("2. Water type pokemons count on the map");
                System.out.println("3. Fire type pokemons count on the map");
                System.out.println("4. Ground type pokemons count on the map");
                System.out.println("5. Grass type pokemons count on the map");
                System.out.println("6. Pokemons critical base chance");
                System.out.println("0. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInPokemonsSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();
            }
            switch (choiceInPokemonsSettings) {
                case 1:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 2:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 3:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 4:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 5:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 6:
                    //nw co tutaj w sensie skoro l jest zwiekszana przy tworzeniu obiektu to nw
                    break;
                case 0:
                    System.out.println("Leaving");
                    return 0;

                default:
                    System.out.println("Your input was invalid. Please choose number between 0-6.");
                    break;
            }
        }
    }

}



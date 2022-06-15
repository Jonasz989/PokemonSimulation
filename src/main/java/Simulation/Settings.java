package Simulation;

import java.util.Scanner;


public class Settings{
    static Scanner scanner = new Scanner(System.in);

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static int expChoice1 = -1, expChoice2 = -1, expChoice3 = -1;
    static int choice0=-1, choice1=-1, choice2=-1, choice3=-1, choice4=-1;
    static float choice5=-1;


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //printing current settings for the user
    public static void printSettings() {

        System.out.println("1. Pokemons trainer's name: "+ Trainer.getNameOfPokemonsTrainer());
        System.out.println("2. Size of the map: "+ Map.getH() + "x" + Map.getW());
        System.out.println("3. Special fields: ");
        System.out.println("- Fire Type: " + Map.getFireFieldsOnTheMap());
        System.out.println("- Water Type: " + Map.getWaterFieldsOnTheMap());
        System.out.println("- Ground Type: " + Map.getGroundFieldsOnTheMap());
        System.out.println("- Grass Type: " + Map.getGrassFieldsOnTheMap());
        System.out.println("4. Type of trainer's pokemon: " + Trainer.getTypeOfTrainersPokemon());
        System.out.println("5. Count of pokemons on the map: "+ Pokemon.getHowManyPokemonsShouldBeOnTheMap());
        System.out.println("6. Types of pokemons on the map: ");
        System.out.println("- Fire Type: " + PokemonFire.getHowManyFirePokemonsOnTheMap());
        System.out.println("- Water Type: " + PokemonWater.getHowManyWaterPokemonsOnTheMap());
        System.out.println("- Ground Type: " + PokemonGround.getHowManyGroundPokemonsOnTheMap());
        System.out.println("- Grass Type: " + PokemonGrass.getHowManyGrassPokemonsOnTheMap());
        System.out.println("7. Trainer's pokemon's base chance of winning: " + Trainer.getTrainersWinningBaseChance());
        System.out.println("8. Trainer's pokemon's base chance of derivation of critical hit: " + Trainer.getTrainersCriticalHitBaseChance());
        System.out.println("9. Pokemons' base chance of derivation of critical hit: " + Pokemon.getPokemonsCriticalHitBaseChance());
        System.out.println("10. Trainer's exp to get 2. level: " + Trainer.getExpFor2Level());
        System.out.println("11. Trainer's exp to get 3. level: " + Trainer.getExpFor3Level());
        System.out.println("12. Trainer's exp to get 4. level: " + Trainer.getExpFor4Level());
        System.out.println("14. Type of saving the results: work in progress");
        System.out.println("Press enter to continue ");

    }

    //method that allows user to choose which settings to change
    public static void changeSettings() {
        while(true) {
            int choiceInSettings;

            while(true){
                System.out.println("Choose which settings you want to change");
                System.out.println("1. Map's");
                System.out.println("2. Trainer's");
                System.out.println("3. Pokemons'");
                System.out.println("4. Saving options");
                System.out.println("0. Exit");
                //scanner.nextLine();
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
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
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose a number between 0-4.");
                    break;
            }
        }
    }

    //method that allows user to change map settings
    public static void changeMapSettings() {
        int choiceInMapSettings;
        while(true) {
            while(true){
                System.out.println("Choose which setting you want to change");
                System.out.println("1. Size of the map");
                System.out.println("2. % chance of generating pool");
                System.out.println("0. Exit");
                scanner.nextLine();
                boolean isOutputProper = scanner.hasNextInt();
                if(isOutputProper){
                    choiceInMapSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }

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
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-2.");
                    break;
            }
        }
    }

    //START OF METHODS FOR THE MAP'S SETTINGS////////////////////////////

    //method that allows user to change size of the map
    static void changeSizeOfTheMap() {
        while(true) {
            System.out.println("Current height is " + Map.getH() + ".");
            System.out.println("Type your new height: ");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            int newH;
            if(test) {
                newH = scanner.nextInt();
                Map.setH(newH);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
        while(true) {
            System.out.println("Current width is " + Map.getW() + ".");
            System.out.println("Type your new width: ");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            int newW;
            if(test){
                newW = scanner.nextInt();
                Map.setW(newW);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change field settings
    static void changeFieldSettings() {
        while (true) {
            int choiceInPoolSettings;
            while(true){
                System.out.println("Select what type of field you want to change.");
                System.out.println("1. Fire");
                System.out.println("2. Water");
                System.out.println("3. Ground");
                System.out.println("4. Grass");
                System.out.println("0. Exit");
                scanner.nextLine();
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInPoolSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
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
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose a number between 0-4.");
                    break;
            }
        }
    }

    //method that allows user to change chance for generating fire fields
    static void changeChanceOfGeneratingFireField() {
        while(true) {
            System.out.println("Current chance of generating fire pool is" + Map.getFireFieldsOnTheMap());
            System.out.println("Type new chance: ");
            scanner.nextLine();
            int newFireFieldsOnTheMap;
            boolean test = scanner.hasNextInt();
            if(test){
                newFireFieldsOnTheMap = scanner.nextInt();
                Map.setFireFieldsOnTheMap(newFireFieldsOnTheMap);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change chance for generating water fields
    static void changeChanceOfGeneratingWaterPool() {
        while(true) {
            System.out.println("Current chance of generating water pool is" + Map.getWaterFieldsOnTheMap());
            System.out.println("Type new chance: ");
            scanner.nextLine();
            int newWaterFieldsOnTheMap;
            boolean test = scanner.hasNextInt();
            if(test){
                newWaterFieldsOnTheMap = scanner.nextInt();
                Map.setWaterFieldsOnTheMap(newWaterFieldsOnTheMap);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change chance for generating ground fields
    static void changeChanceOfGeneratingGroundPool() {
        while(true) {
            System.out.println("Current chance of generating ground pool is" + Map.getGroundFieldsOnTheMap());
            System.out.println("Type new chance: ");
            scanner.nextLine();
            int newGroundFieldsOnTheMap;
            boolean test = scanner.hasNextInt();
            if (test){
                newGroundFieldsOnTheMap = scanner.nextInt();
                Map.setGroundFieldsOnTheMap(newGroundFieldsOnTheMap);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change chance for generating grass fields
    static void changeChanceOfGeneratingGrassPool() {
        while(true){
        System.out.println("Current chance of generating grass pool is" + Map.getGrassFieldsOnTheMap());
        System.out.println("Type new chance: ");
        scanner.nextLine();
        int newGrassFieldsOnTheMap;
        boolean test = scanner.hasNextInt();
            if (test){
                newGrassFieldsOnTheMap = scanner.nextInt();
                Map.setGrassFieldsOnTheMap(newGrassFieldsOnTheMap);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }

        }
    }
    //END OF METHODS FOR THE MAP'S SETTINGS////////////////////////////


    //method that allows user to change trainer's settings
    public static void changeTrainersSettings() {
        while (true) {
            int choiceInTrainersSettings;

            while(true){
                System.out.println("Which trainer's settings would you like to change: ");
                System.out.println("1. Trainer's name");
                System.out.println("2. Trainer's pokemon type");
                System.out.println("3. Trainer's winning base chance");
                System.out.println("4. Trainer's critical hit base chance");
                System.out.println("5. Trainer's exp to get 2. level");
                System.out.println("6. Trainer's exp to get 3. level");
                System.out.println("7. Trainer's exp to get 4. level");
                System.out.println("8. Save exp's choices");
                System.out.println("0. Exit");
                scanner.nextLine();
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInTrainersSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }

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
                case 5:
                    changeTrainersExpToGet2Level();
                    break;
                case 6:
                    changeTrainersExpToGet3Level();
                    break;
                case 7:
                    changeTrainersExpToGet4Level();
                    break;
                case 8:
                    savingExpChoices();
                    break;
                case 0:
                    System.out.println("Leaving");
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-4.");
                    break;
            }
        }
    }

    //START OF METHODS FOR THE TRAINERS'S SETTINGS////////////////////////////

    //method that allows user to change trainer's name
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

    //method that allows user to change trainer's winning base chance
    public static void changeTrainersWinningBaseChance() {
        float choice;
        while(true) {
            System.out.println("Current Trainer's base winning chance: " +Trainer.getTrainersWinningBaseChance());
            System.out.println("To which number would you like to change it?: ");
            scanner.nextLine();
            boolean test2 = scanner.hasNextFloat();
            if(test2) {
                choice = scanner.nextFloat();
                Trainer.setTrainersWinningBaseChance(choice);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change trainer's critical hit base chance
    public static void changeTrainersCriticalHitBaseChance() {
        float choice;
        while(true) {
            System.out.println("Current Trainer's critical hit base chance: " +Trainer.getTrainersCriticalHitBaseChance());
            System.out.println("To which number would you like to change it?: ");
            scanner.nextLine();
            boolean test = scanner.hasNextFloat();
            if(test) {
                choice = scanner.nextFloat();
                Trainer.setTrainersCriticalHitBaseChance(choice);
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change trainer pokemon's type
    public static void changeTypeOfTrainersPokemon() {
        int choice;
        while (true) {
            while(true){
                System.out.println("You may choose type of the trainer's pokemon from: ");
                System.out.println("1. Fire");
                System.out.println("2. Water");
                System.out.println("3. Ground");
                System.out.println("4. Grass");
                System.out.println("0. Exit");
                scanner.nextLine();
                boolean test = scanner.hasNextInt();
                if(test){
                    choice = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
            }
            switch (choice) {
                case 1:
                    Trainer.setTypeOfTrainersPokemon("F");
                    return;
                case 2:
                    Trainer.setTypeOfTrainersPokemon("W");
                    return;
                case 3:
                    Trainer.setTypeOfTrainersPokemon("G");
                    return;
                case 4:
                    Trainer.setTypeOfTrainersPokemon("g");
                    return;
                case 0:
                    System.out.println("Returning to the settings menu");
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-4.");
                    break;
            }
        }
    }

    //method that allows user to change exp's choices
    public static void savingExpChoices (){
        if (expChoice1==-1) expChoice1 = Trainer.getExpFor2Level();
        if (expChoice2==-1) expChoice2 = Trainer.getExpFor3Level();
        if (expChoice3==-1) expChoice3 = Trainer.getExpFor4Level();

        if (expChoice1<expChoice2 && expChoice2<expChoice3){
            Trainer.setExpFor2Level(expChoice1);
            Trainer.setExpFor3Level(expChoice2);
            Trainer.setExpFor4Level(expChoice3);
            System.out.println("Saved properly.");
        }
        else{
            System.out.println("Exp's choices are wrong. You cannot assign higher or equal value than next level's to a lower level.");
        }

    }

    //method that allows user to change required exp to get 2. level
    public static void changeTrainersExpToGet2Level (){
        while(true) {
            System.out.println("Current Trainer's exp to get 2. level: " + Trainer.getExpFor2Level());
            System.out.println("To which value would you like to change it? :");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if (test) {
                expChoice1 = scanner.nextInt();
                if(expChoice1<0){
                    expChoice1 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            } else {
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change required exp to get 3. level
    public static void changeTrainersExpToGet3Level (){
        while(true) {
            System.out.println("Current Trainer's exp to get 3. level: " + Trainer.getExpFor3Level());
            System.out.println("To which value would you like to change it? :");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if (test) {
                expChoice2 = scanner.nextInt();
                if(expChoice2<0){
                    expChoice2 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            } else {
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //method that allows user to change required exp to win the simulation
    public static void changeTrainersExpToGet4Level (){
        while(true) {
            System.out.println("Current Trainer's exp to get 4. level: " + Trainer.getExpFor4Level());
            System.out.println("To which value would you like to change it? :");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if (test) {
                expChoice3 = scanner.nextInt();
                if(expChoice3<0){
                    expChoice3 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            } else {
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //END OF METHODS FOR THE TRAINERS'S SETTINGS////////////////////////////


    //method that allows user to change pokemons' settings
    public static void changePokemonsSettings() {
        while (true) {

            int choiceInPokemonsSettings;
            while(true){
                System.out.println("Which pokemons' settings would you like to change: ");
                System.out.println("1. Pokemons count on the map");
                System.out.println("2. Water type pokemons count on the map");
                System.out.println("3. Fire type pokemons count on the map");
                System.out.println("4. Ground type pokemons count on the map");
                System.out.println("5. Grass type pokemons count on the map");
                System.out.println("6. Pokemons' critical base chance");
                System.out.println("7. Save");
                System.out.println("0. Exit");
                scanner.nextLine();
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceInPokemonsSettings = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
            }
            switch (choiceInPokemonsSettings) {
                case 1:
                    changeHowManyPokemonsShouldBeOnTheMap();
                    break;
                case 2:
                    changeHowManyWaterPokemonsShouldBeOnTheMap();
                    break;
                case 3:
                    changeHowManyFirePokemonsShouldBeOnTheMap();
                    break;
                case 4:
                    changeHowManyGroundPokemonsShouldBeOnTheMap();
                    break;
                case 5:
                    changeHowManyGrassPokemonsShouldBeOnTheMap();
                    break;
                case 6:
                    changePokemonsCriticalHitBaseChance();
                    break;
                case 7:
                    savingPokemonsSettings();
                    break;
                case 0:
                    System.out.println("Leaving");
                    return;
                default:
                    System.out.println("Your input was invalid. Please choose number between 0-6.");
                    break;
            }
        }
    }
    //START OF METHODS FOR THE POKEMONS' SETTINGS////////////////////////////

    //method that saves pokemons' settings if possible
    public static void savingPokemonsSettings (){
        if (choice0==-1) choice0 = Pokemon.getHowManyPokemonsShouldBeOnTheMap();
        if (choice1==-1) choice1 = PokemonWater.getHowManyWaterPokemonsOnTheMap();
        if (choice2==-1) choice2 = PokemonFire.getHowManyFirePokemonsOnTheMap();
        if (choice3==-1) choice3 = PokemonGround.getHowManyGroundPokemonsOnTheMap();
        if (choice4==-1) choice4 = PokemonGrass.getHowManyGrassPokemonsOnTheMap();


        if (choice0 ==  choice1 + choice2 + choice3+ choice4 ){
            Pokemon.setHowManyPokemonsShouldBeOnTheMap(choice0);
            PokemonWater.setHowManyWaterPokemonsOnTheMap(choice1);
            PokemonFire.setHowManyFirePokemonsOnTheMap(choice2);
            PokemonGrass.setHowManyGrassPokemonsOnTheMap(choice3);
            PokemonGround.setHowManyGroundPokemonsOnTheMap(choice4);
            System.out.println("Saved properly.");
        }
        else{
            int sum = choice1+choice2+choice3+choice4;
            System.out.println("Sorry, but the count of how many pokemons should be on the map is not equal to the sum of pokemons of each type");
            System.out.println("The count of how many pokemons on the map: " + choice0);
            System.out.println("The sum of pokemons of each type: " + sum);
            System.out.println("Please adjust your preferences accordingly.");
        }
    }


    //method that allows user to change how many pokemons should be on the map
    public static void changeHowManyPokemonsShouldBeOnTheMap(){
        while(true) {
            System.out.println("Pokemons on the map: " + Pokemon.getHowManyPokemonsShouldBeOnTheMap());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if(test) {
                choice0 = scanner.nextInt();
                if (choice0 < 0) {
                    choice0 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }


    //method that allows user to change how many water pokemons should be on the map
    public static void changeHowManyWaterPokemonsShouldBeOnTheMap(){
        while(true) {
            System.out.println("Water pokemons on the map: " + PokemonWater.getHowManyWaterPokemonsOnTheMap());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if(test) {
                choice1 = scanner.nextInt();
                if (choice1 < 0) {
                    choice1 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }


    //method that allows user to change how many fire pokemons should be on the map
    public static void changeHowManyFirePokemonsShouldBeOnTheMap(){
        while(true) {
            System.out.println("Fire pokemons on the map: " + PokemonFire.getHowManyFirePokemonsOnTheMap());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if(test) {
                choice2 = scanner.nextInt();
                if (choice2 < 0) {
                    choice2 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }


    //method that allows user to change how many ground pokemons should be on the map
    public static void changeHowManyGroundPokemonsShouldBeOnTheMap(){
        while(true) {
            System.out.println("Ground pokemons on the map: " + PokemonGround.getHowManyGroundPokemonsOnTheMap());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if(test) {
                choice3 = scanner.nextInt();
                if (choice3 < 0) {
                    choice3 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }


    //method that allows user to change how many grass pokemons should be on the map
    public static void changeHowManyGrassPokemonsShouldBeOnTheMap(){
        while(true) {
            System.out.println("Grass pokemons on the map: " + PokemonGrass.getHowManyGrassPokemonsOnTheMap());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextInt();
            if(test) {
                choice4 = scanner.nextInt();
                if (choice4 < 0) {
                    choice4 = -1;
                    System.out.println("You can't choose negative number");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }


    //method that allows user to change pokemons' critical hit base chance
    public static void changePokemonsCriticalHitBaseChance(){
        while(true) {
            System.out.println("Pokemons' critical hit base chance: " + Pokemon.getPokemonsCriticalHitBaseChance());
            System.out.println("How many should be then?");
            scanner.nextLine();
            boolean test = scanner.hasNextFloat();
            if(test) {
                choice5 = scanner.nextFloat();
                if (choice5 > 0) {
                    Pokemon.setPokemonsCriticalHitBaseChance(choice5);
                } else {
                    System.out.println("You can't choose negative number. Please try again.");
                }
                break;
            }
            else{
                System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                System.out.println(" ");
            }
        }
    }

    //END OF METHODS FOR THE POKEMONS' SETTINGS////////////////////////////
}



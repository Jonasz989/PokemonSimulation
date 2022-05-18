import java.util.Scanner;

public class Settings extends Menu {

    //initialization of map object and giving the object default values
    Map map = new Map(10, 10);

    //initialization of trainer object and giving the trainer default values
    Trainer trainer = new Trainer("Ass", 10.0f,0.10f,"fire" );


    Scanner scanner = new Scanner(System.in);


    /**
     * Printing current settings to user
     */
    public void printSettings() {

        System.out.println("1. Size of the map: "+ map.getH() + "x" +map.getW());
        System.out.println("2. Special fields: ");
        System.out.println("- Fire Type: "+map.getFireFieldsOnTheMap());
        System.out.println("- Water Type: "+map.getWaterFieldsOnTheMap());
        System.out.println("- Ground Type: "+map.getGroundFieldsOnTheMap());
        System.out.println("- Grass Type: "+map.getGrassFieldsOnTheMap());
        System.out.println("3. Type of trainer's pokemon: " + Trainer.getTypeOfTrainersPokemon());
        System.out.println("4. Count of pokemons on the map: "+ Pokemon.getCountOfPokemonOnTheMap());
        System.out.println("5. Types of pokemons on the map: ");
        System.out.println("- Fire Type: " + PokemonFire.getFirePokemonsOnTheMap());
        System.out.println("- Water Type: " + PokemonWater.getWaterPokemonsOnTheMap());
        System.out.println("- Ground Type: " + PokemonGround.getGroundPokemonsOnTheMap());
        System.out.println("- Grass Type: " + PokemonGrass.getGrassPokemonsOnTheMap());
        System.out.println("6. Trainer's pokemon's base chance of winning: " + Trainer.getTrainersWinningBaseChance());
        System.out.println("7. Trainer's pokemon's base chance of derivation of critical hit: " + Trainer.getTrainersCriticalHitBaseChance());
        System.out.println("8. Pokemons' base chance of derivation of critical hit: " + Pokemon.getPokemonsCriticalHitBaseChance());
        System.out.println("9. Type of saving the results: ");
        System.out.println("Press enter to continue ");

    }

    /**
     * Method that show us menu to changing settings to our simulation
     */
    public int changeSettings() {
        while(true) {
            int choiceInSettings;
            System.out.println("Choose which settings you want to change");
            System.out.println("1. Map");
            System.out.println("2. Trainer's");
            System.out.println("3. Pokemons'");
            System.out.println("4. Saving options");
            System.out.println("5. Exit");

            choiceInSettings = scanner.nextInt();
            switch(choiceInSettings) {
                case 1:
                    changeMapSettings();
                    break;
                case 2:
                    changeTrainersSettings();
                    break;
                case 3:
                    changePokemonsSettings();
                    break;
                case 4:
                    //tutaj bedzie ta funkcja ale napiszemy po wykladzie mrozona dopiero
                    break;
                case 5:
                    System.out.println("Going back to main menu");
                    return 0;
                default:
                    System.out.println("Your input was invalid. Please choose a number between 1-5.");
                    break;
            }
        }

    }

    /**
     * Method for changing map setting
     */
    public int changeMapSettings() {
        int choiceInMapSettings;
        while(true) {
        System.out.println("Choose which setting you want to change");
        System.out.println("1. Size of the map");
        System.out.println("2. % chance of generating pool");
        System.out.println("3. Exit");
        choiceInMapSettings = scanner.nextInt();
        switch (choiceInMapSettings) {
            case 1:
                System.out.println("Current height is " + map.getH() + ".");
                System.out.println("Type your new height: ");
                int newH=0;
                newH = scanner.nextInt();
                map.setH(newH);
                System.out.println("Current width is " + map.getW() + ".");
                System.out.println("Type your new width: ");
                int newW=0;
                newW = scanner.nextInt();
                map.setW(newW);
                break;
            case 2:
                while (true) {
                    int choiceInPoolSettings;
                    System.out.println("Select what type of field you want to change.");
                    System.out.println("1. Fire");
                    System.out.println("2. Water");
                    System.out.println("3. Ground");
                    System.out.println("4. Grass");
                    System.out.println("5. Exit");
                    choiceInPoolSettings = scanner.nextInt();
                    switch (choiceInPoolSettings) {
                        case 1:
                            System.out.println("Current chance of generating fire pool is" + map. getFireFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            map.newFireFieldsOnTheMap = scanner.nextInt();
                            map.setFireFieldsOnTheMap(map.newFireFieldsOnTheMap);
                            break;
                        case 2:
                            System.out.println("Current chance of generating water pool is" + map.getWaterFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            map.newWaterFieldsOnTheMap = scanner.nextInt();
                            map.setWaterFieldsOnTheMap(map.newWaterFieldsOnTheMap);
                            break;
                        case 3:
                            System.out.println("Current chance of generating ground pool is" + map.getGroundFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            map.newGroundFieldsOnTheMap = scanner.nextInt();
                            map.setGroundFieldsOnTheMap(map.newGroundFieldsOnTheMap);
                            break;
                        case 4:
                            System.out.println("Current chance of generating grass pool is" + map.getGrassFieldsOnTheMap());
                            System.out.println("Type new chance: ");
                            map.newGrassFieldsOnTheMap = scanner.nextInt();
                            map.setGrassFieldsOnTheMap(map.newGrassFieldsOnTheMap);
                            break;
                        case 5:
                            System.out.println("Returning to map settings");
                            changeMapSettings();
                        default:
                            System.out.println("Your input was invalid. Please choose a number between 1-5.");
                            continue;
                    }
                    break;
                }
                break;
            case 3:
                System.out.println("Returning to the settings menu");
                return 0;
            default:
                System.out.println("Your input was invalid. Please choose number between 1-3.");
                continue;
            }
        }
    }





    public void changePokemonsTrainersName(){
        System.out.println("To which name would you like to change it?: ");
        String choice;
        choice = scanner.next();
        trainer.setNameOfPokemonsTrainer(choice);
    }

    public void changeTrainersWinningBaseChance() {
        float choice;
        choice = scanner.nextInt();
        trainer.setTrainersWinningBaseChance(choice);
    }
    public void changeTrainersCriticalHitBaseChance() {
        float choice;
        choice = scanner.nextInt();
        trainer.setTrainersCriticalHitBaseChance(choice);
    }
    public int changeTypeOfTrainersPokemon() {
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
                Trainer.setTypeOfTrainersPokemon("fire");
                break;
            case 2:
                Trainer.setTypeOfTrainersPokemon("water");
                break;
            case 3:
                Trainer.setTypeOfTrainersPokemon("ground");
                break;
            case 4:
                Trainer.setTypeOfTrainersPokemon("grass");
                break;
            case 5:
                System.out.println("Returning to the settings menu");
                return 0;
            default:
                System.out.println("Your input was invalid. Please choose number between 1-5.");
                continue;
            }
        }
    }

    public int changeTrainersSettings() {
        while (true) {
            System.out.println("Which trainer's settings would you like to change: ");
            System.out.println("1. Trainer's name");
            System.out.println("2. Trainer's pokemon type");
            System.out.println("3. Trainer's winning base chance");
            System.out.println("4. Trainer's critical hit base chance");
            System.out.println("5. Exit");

            int choiceInTrainersSettings = 0;
            choiceInTrainersSettings = scanner.nextInt();
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
                    System.out.println("Leaving");
                    return 0;

                default:
                    System.out.println("Your input was invalid. Please choose number between 1-5.");
                    continue;
            }
        }
    }
        public void changePokemonsCountOnTheMap(){
            System.out.println("How many should be then?");
            int choice=0;
            choice = scanner.nextInt();

        }






        public int changePokemonsSettings() {
            while (true) {
                System.out.println("Which pokemons' settings would you like to change: ");
                System.out.println("1. Pokemons count on the map");
                System.out.println("2. Water type pokemons count on the map");
                System.out.println("3. Fire type pokemons count on the map");
                System.out.println("4. Ground type pokemons count on the map");
                System.out.println("5. Grass type pokemons count on the map");
                System.out.println("6. Pokemons critical base chance");
                System.out.println("7. Exit");

                int choiceInPokemonsSettings = 0;
                choiceInPokemonsSettings = scanner.nextInt();
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
                    case 7:
                        System.out.println("Leaving");
                        return 0;

                    default:
                        System.out.println("Your input was invalid. Please choose number between 1-7.");
                        continue;
                }
            }
        }
}


package Simulation;
import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    public static ArrayList<Pokemon> arrayOfPokemons = new ArrayList<>();

    static Random rand = new Random();
    static String WATER = "W";
    static String FIRE = "F";
    static String GROUND = "G";
    static String GRASS = "g";


    //starting the simulation
    public static void start(Field[][] flatMap, Trainer trainer) {
        fillMap(flatMap);
        System.out.println("Empty map:");
        printMap(flatMap);
        generateMapFields(flatMap);
        System.out.println("Where are the special fields on the map:");
        printMap(flatMap);
        System.out.println("Placing trainer on the map...");
        generatingTrainerOnTheMap(flatMap, trainer);
        printCurrentSimulationState(flatMap);
        System.out.println("Placing pokemons on the map..");
        generatingPokemons(flatMap);
        printCurrentSimulationState(flatMap);

        for (int i = 0; i < 5; i++) {
            trainer.moveTrainer(flatMap, trainer, arrayOfPokemons);
            for(Pokemon pox : arrayOfPokemons) {
                pox.movePokemon(flatMap, trainer);
            }
            printCurrentSimulationState(flatMap);
        }
    }


    //printing empty map
    public static void printMap(Field[][] flatMap) {
        //System.out.println("\nACTUAL MAP3");
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                System.out.print(flatMap[i][j].fieldType + " ");
            }
            System.out.println();
        }
    }

    //printing current state of the simulation
    public static void printCurrentSimulationState(Field[][] flatMap) {
        System.out.println("\nCURRENT STATE");
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                if (flatMap[i][j].isOccupiedByTrainer) {
                    System.out.print("T ");
                } else if(!(flatMap[i][j].isOccupied)) {
                    System.out.print(". ");
                } else {
                    System.out.print("P ");
                }
            }
            System.out.println();
        }
    }

    //filling map with normal fields
    public static void fillMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j] = new Field();
            }
        }
    }

    //filling map with special fields
    public static void generateMapFields(Field[][] flatMap) {
        int zmienna = Map.getSumOfSpecialFields();
        int actualNumberOfWaterFields = Map.getWaterFieldsOnTheMap();
        int actualNumberOfFireFields = Map.getFireFieldsOnTheMap();
        int actualNumberOfGroundFields = Map.getGroundFieldsOnTheMap();
        int actualNumberOfGrassFields = Map.getGrassFieldsOnTheMap();
        for (int z = 0; z < zmienna; ) {
            while (actualNumberOfFireFields != 0) {
                int generatedI;
                int generatedJ;
                do {
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                } while (!flatMap[generatedI][generatedJ].fieldType.equals("."));

                    flatMap[generatedI][generatedJ].setFieldType(FIRE);
                    z++;
                actualNumberOfFireFields--;
            }

            while (actualNumberOfWaterFields != 0) {
                int generatedI;
                int generatedJ;
                do {
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                } while (!flatMap[generatedI][generatedJ].fieldType.equals("."));

                if (flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(WATER);
                    z++;
                    actualNumberOfWaterFields--;
                }
            }

            while (actualNumberOfGroundFields != 0) {
                int generatedI;
                int generatedJ;
                do {
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                } while (!flatMap[generatedI][generatedJ].fieldType.equals("."));

                if (flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(GROUND);
                    z++;
                    actualNumberOfGroundFields--;
                }
            }

            while (actualNumberOfGrassFields != 0) {
                int generatedI;
                int generatedJ;
                do {
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                } while (!flatMap[generatedI][generatedJ].fieldType.equals("."));

                if (flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(GRASS);
                    z++;
                    actualNumberOfGrassFields--;
                }
            }
        }
    }

    //generating pokemons on the map
    public static void generatingPokemons(Field[][] flatMap) {
        for (; Pokemon.getCountOfPokemonOnTheMap() < Pokemon.getHowManyPokemonsShouldBeOnTheMap();){
            int fire = PokemonFire.getHowManyFirePokemonsOnTheMap();
            while (fire!=0){
                PokemonFire poks = new PokemonFire(rand.nextInt(3)+1, -1, -1, "F");
                arrayOfPokemons.add(poks);
                fire--;
            }
            int water = PokemonWater.getHowManyWaterPokemonsOnTheMap();
            while (water!=0){
                PokemonWater poks = new PokemonWater(rand.nextInt(3)+1, -1, -1, "W");
                arrayOfPokemons.add(poks);
                water--;
            }
            int ground = PokemonGround.getHowManyGroundPokemonsOnTheMap();
            while (ground!=0){
                PokemonGround poks = new PokemonGround(rand.nextInt(3)+1, -1, -1, "G");
                arrayOfPokemons.add(poks);
                ground--;
            }
            int grass = PokemonGrass.getHowManyGrassPokemonsOnTheMap();
            while (grass!=0){
                PokemonGrass poks = new PokemonGrass(rand.nextInt(3)+1, -1, -1, "g");
                arrayOfPokemons.add(poks);
                grass--;
            }
        }
        int generatedI;
        int generatedJ;
        for (Pokemon pokemon:arrayOfPokemons){
            do{
                generatedI = rand.nextInt(Map.getH());
                generatedJ = rand.nextInt(Map.getW());
            }
            while(flatMap[generatedI][generatedJ].isOccupied || flatMap[generatedI][generatedJ].isOccupiedByTrainer);
            flatMap[generatedI][generatedJ].setOccupied(true);
            pokemon.setXposition(generatedJ);
            pokemon.setYposition(generatedI);
        }
    }

    //generating trainer on the map
    public static void generatingTrainerOnTheMap(Field[][] flatMap, Trainer trainer) {
        int generatedI;
        int generatedJ;
        generatedI = rand.nextInt(Map.getH());
        generatedJ = rand.nextInt(Map.getW());
        trainer.setXposition(generatedJ);
        trainer.setYposition(generatedI);
        flatMap[generatedI][generatedJ].setOccupiedByTrainer(true);
    }





}


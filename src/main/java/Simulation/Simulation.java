package Simulation;
import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    public static ArrayList<Pokemon> arrayOfPokemons = new ArrayList<>();

    static int levelOfDeletedPokemon = 0;
    static Random rand = new Random();
    static String WATER = "W";
    static String FIRE = "F";
    static String GROUND = "G";
    static String GRASS = "g";


    //starting the simulation
    public static void start(Field[][] flatMap, Trainer trainer) {
        arrayOfPokemons.clear();
        fillMap(flatMap);
        zerowanieMapyITrenera(flatMap,trainer);
        generateMapFields(flatMap);
        System.out.println("Where are the special fields on the map:");
        printMap(flatMap);
        generatingTrainerOnTheMap(flatMap, trainer);
        generatingPokemons(flatMap);
        printCurrentSimulationState(flatMap);


        do{
            trainer.moveTrainer(flatMap, arrayOfPokemons);

            if(pokemonRemover(flatMap, trainer)){
                if (trainer.catchPokemon(getLevelOfDeletedPokemon())){
                    trainer.setHowManyPokemonsKilled(trainer.getHowManyPokemonsKilled()+2);
                }
                else {

                }
            }

            for(Pokemon pox : arrayOfPokemons) {
                pox.movePokemon(flatMap, trainer);
            }

            if(pokemonRemover(flatMap, trainer)){
                if (trainer.catchPokemon(getLevelOfDeletedPokemon())){
                    trainer.setHowManyPokemonsKilled(trainer.getHowManyPokemonsKilled()+2);
                }
                else{

                }

            }

            printCurrentSimulationState(flatMap);
        } while (trainer.checkingProgress() && !(arrayOfPokemons.isEmpty()));


    }

    public static boolean pokemonRemover(Field[][] flatMap, Trainer trainer) {
        for (int i = 0; i < arrayOfPokemons.size(); i++) {
            if (arrayOfPokemons.get(i).getYposition() == trainer.getYposition() && arrayOfPokemons.get(i).getXposition() == trainer.getXposition()) {
                flatMap[arrayOfPokemons.get(i).getYposition()][arrayOfPokemons.get(i).getXposition()].setOccupied(false);
                setLevelOfDeletedPokemon(arrayOfPokemons.get(i).getLevel());
                arrayOfPokemons.get(i).setYposition(-100);
                arrayOfPokemons.get(i).setXposition(-100);
                arrayOfPokemons.remove(i);
                return true;
            }
        }
        return false;
    }


    public static void zerowanieMapyITrenera(Field[][] flatMap, Trainer trainer) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j].setFieldType(".");
                flatMap[i][j].setOccupied(false);
                flatMap[i][j].setOccupiedByTrainer(false);
            }
            trainer.setXposition(0);
            trainer.setYposition(0);
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
                if (flatMap[i][j].isOccupiedByTrainer() && flatMap[i][j].isOccupied()) {
                    System.out.print("D ");
                } else
                if (flatMap[i][j].isOccupiedByTrainer() && !flatMap[i][j].isOccupied()) {
                    System.out.print("T ");
                } else if(flatMap[i][j].isOccupied() && !flatMap[i][j].isOccupiedByTrainer()) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
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
        int howManyPokemons = Pokemon.getSumOfHowManyPokemonsThereShouldBe();
        int createdPokemons = 0;
        int actualNumberOfWaterPokemons = PokemonWater.getHowManyWaterPokemonsOnTheMap();
        int actualNumberOfFirePokemons = PokemonFire.getHowManyFirePokemonsOnTheMap();
        int actualNumberOfGroundPokemons = PokemonGround.getHowManyGroundPokemonsOnTheMap();
        int actualNumberOfGrassPokemons = PokemonGrass.getHowManyGrassPokemonsOnTheMap();
        while (createdPokemons < howManyPokemons) {
            while (actualNumberOfWaterPokemons > 0) {
                int generatedI;
                int generatedJ;
                do{
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                }
                while(flatMap[generatedI][generatedJ].isOccupied() || flatMap[generatedI][generatedJ].isOccupiedByTrainer());
                Pokemon poks = new PokemonWater(rand.nextInt(3)+1, generatedJ, generatedI, "W");
                flatMap[generatedI][generatedJ].setOccupied(true);
                arrayOfPokemons.add(poks);
                createdPokemons++;
                actualNumberOfWaterPokemons--;
            }

            while (actualNumberOfFirePokemons > 0) {
                int generatedI;
                int generatedJ;
                do{
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                }
                while(flatMap[generatedI][generatedJ].isOccupied() || flatMap[generatedI][generatedJ].isOccupiedByTrainer());
                Pokemon poks = new PokemonFire(rand.nextInt(3)+1, generatedJ, generatedI, "W");
                flatMap[generatedI][generatedJ].setOccupied(true);
                arrayOfPokemons.add(poks);
                createdPokemons++;
                actualNumberOfFirePokemons--;
            }

            while (actualNumberOfGroundPokemons > 0) {
                int generatedI;
                int generatedJ;
                do{
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                }
                while(flatMap[generatedI][generatedJ].isOccupied() || flatMap[generatedI][generatedJ].isOccupiedByTrainer());
                Pokemon poks = new PokemonGround(rand.nextInt(3)+1, generatedJ, generatedI, "G");
                flatMap[generatedI][generatedJ].setOccupied(true);
                arrayOfPokemons.add(poks);
                createdPokemons++;
                actualNumberOfGroundPokemons--;
            }

            while (actualNumberOfGrassPokemons > 0) {
                int generatedI;
                int generatedJ;
                do{
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                }
                while(flatMap[generatedI][generatedJ].isOccupied() || flatMap[generatedI][generatedJ].isOccupiedByTrainer());
                Pokemon poks = new PokemonGrass(rand.nextInt(3)+1, generatedJ, generatedI, "g");
                flatMap[generatedI][generatedJ].setOccupied(true);
                arrayOfPokemons.add(poks);
                createdPokemons++;
                actualNumberOfGrassPokemons--;
            }

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


    public static int getLevelOfDeletedPokemon() {
        return levelOfDeletedPokemon;
    }

    public static void setLevelOfDeletedPokemon(int levelOfDeletedPokemon) {
        Simulation.levelOfDeletedPokemon = levelOfDeletedPokemon;
    }
}
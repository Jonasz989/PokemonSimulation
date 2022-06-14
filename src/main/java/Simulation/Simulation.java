package Simulation;
import java.util.Random;

public class Simulation {

    public static ArrayList<Pokemon> arrayOfPokemons = new ArrayList<>();

    Random rand = new Random();
    String WATER = "W";
    String FIRE = "F";
    String GROUND = "G";
    String GRASS = "g";


    Field[][] flatMap = new Field[Map.getH()][Map.getW()];
    Trainer trainer = new Trainer(Trainer.getNameOfPokemonsTrainer(), Trainer.getTrainersWinningBaseChance(), Trainer.getTrainersCriticalHitBaseChance(), Trainer.getTypeOfTrainersPokemon(), Trainer.getIDofPokemonTrainer(), Trainer.getLevelofPokemonTrainer(), Trainer.getHowManyPokemonsKilled(), Trainer.getXposition(), Trainer.getYposition());


    public void start(Field[][] flatMap) {

        fillMap(flatMap);
        //printMap(flatMap);
        generateMapFields(flatMap);
        //printMap(flatMap);
        generatingTrainerOnTheMap(flatMap);
        System.out.println("dupa1");
        printCurrentSimulationState(flatMap);
        generatingPokemons(flatMap);
        System.out.println("dupa2");
        printCurrentSimulationState(flatMap);
        System.out.println("przed symulacja");
        for(int i = 0; i < 1; i++) {
            //trainer.movingTrainerThroughTheMap(flatMap);
            for(Pokemon poks: arrayOfPokemons) {
                poks.movePokemon(flatMap, trainer);
            }
            printCurrentSimulationState(flatMap);
        }
    }


    public void printMap(Field[][] flatMap) {
        System.out.println("\nACTUAL MAP");
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                System.out.print(flatMap[i][j].fieldType + " ");
            }
            System.out.println();
        }
    }

    public void printCurrentSimulationState(Field[][] flatMap) {
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

    public void fillMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j] = new Field();
            }
        }
    }

    public void generateMapFields(Field[][] flatMap) {
        int zmienna = Map.getSumOfSpecialFields();
        int actualNumberOfWaterFields = Map.getWaterFieldsOnTheMap();
        int actualNumberOfFireFields = Map.getFireFieldsOnTheMap();
        int actualNumberOfGroundFields = Map.getGroundFieldsOnTheMap();
        int actualNumberOfGrassFields = Map.getGrassFieldsOnTheMap();

        for (int z = 0; z < Map.getSumOfSpecialFields();) {
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

                if(flatMap[generatedI][generatedJ].fieldType.equals(".")) {
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

                if(flatMap[generatedI][generatedJ].fieldType.equals(".")) {
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

                if(flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(GRASS);
                    z++;
                    actualNumberOfGrassFields--;
                }
            }
        }
    }

    public void generatingPokemons(Field[][] flatMap) {
        for (int i=0; i < Pokemon.getHowManyPokemonsShouldBeOnTheMap();){
            int fire = PokemonFire.getFirePokemonsOnTheMap();
            while (fire!=0){
                PokemonFire poks = new PokemonFire(rand.nextInt(2)+1, -1, -1, "F");
                arrayOfPokemons.add(poks);
                fire--;
                i++;
            }
            int water = PokemonWater.getWaterPokemonsOnTheMap();
            while (water!=0){
                PokemonWater poks = new PokemonWater(rand.nextInt(2)+1, -1, -1, "W");
                arrayOfPokemons.add(poks);
                water--;
                i++;
            }
            int ground = PokemonGround.getGroundPokemonsOnTheMap();
            while (ground!=0){
                PokemonGround poks = new PokemonGround(rand.nextInt(2)+1, -1, -1, "G");
                arrayOfPokemons.add(poks);
                ground--;
                i++;
            }
            int grass = PokemonGrass.getGrassPokemonsOnTheMap();
            while (grass!=0){
                PokemonGrass poks = new PokemonGrass(rand.nextInt(2)+1, -1, -1, "g");
                arrayOfPokemons.add(poks);
                grass--;
                i++;
            }
        }
        int generatedI;
        int generatedJ;
        for (Pokemon pokemon:arrayOfPokemons){
            do{
                generatedI = rand.nextInt(Map.getH());
                generatedJ = rand.nextInt(Map.getW());
            }
            while(flatMap[generatedI][generatedJ].isOccupied && !flatMap[generatedI][generatedJ].isOccupiedByTrainer);
            flatMap[generatedI][generatedJ].setOccupied(true);
            pokemon.setXposition(generatedJ);
            pokemon.setYposition(generatedI);
        }
    }

    public void generatingTrainerOnTheMap(Field[][] flatMap) {
        int generatedI;
        int generatedJ;
        generatedI = rand.nextInt(Map.getH());
        generatedJ = rand.nextInt(Map.getW());
        trainer.setXposition(generatedJ);
        trainer.setYposition(generatedI);
        flatMap[generatedI][generatedJ].setOccupiedByTrainer(true);
    }


}


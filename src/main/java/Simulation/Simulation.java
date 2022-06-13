package Simulation;
import java.util.Random;

public class Simulation {

    Random rand = new Random();
    String WATER = "W";
    String FIRE = "F";
    String GROUND = "G";
    String GRASS = "g";



    Field[][] flatMap = new Field[Map.getH()][Map.getW()];

    public void start(Field[][] flatMap) {
        createMap(flatMap);
        printMap(flatMap);
        generateMapFields(flatMap);
        printMap(flatMap);
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

    public void createMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j] = new Field();
            }
        }
    }

    public void generateMapFields(Field[][] flatMap) {
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
                } while (flatMap[generatedI][generatedJ].fieldType != ".");

                if(flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(FIRE);
                    z++;
                    actualNumberOfFireFields--;
                }
            }

            while (actualNumberOfWaterFields != 0) {
                int generatedI;
                int generatedJ;
                do {
                    generatedI = rand.nextInt(Map.getH());
                    generatedJ = rand.nextInt(Map.getW());
                } while (flatMap[generatedI][generatedJ].fieldType != ".");

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
                } while (flatMap[generatedI][generatedJ].fieldType != ".");

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
                } while (flatMap[generatedI][generatedJ].fieldType != ".");

                if(flatMap[generatedI][generatedJ].fieldType.equals(".")) {
                    flatMap[generatedI][generatedJ].setFieldType(GRASS);
                    z++;
                    actualNumberOfGrassFields--;
                }
            }

        }



    }

    public void moveTrainer() {
    }


//generating trainer and pokemons

}

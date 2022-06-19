package Simulation;

import Simulation.Pokemon.FromPokemon.PokemonFire;
import Simulation.Pokemon.FromPokemon.PokemonGrass;
import Simulation.Pokemon.FromPokemon.PokemonGround;
import Simulation.Pokemon.FromPokemon.PokemonWater;
import Simulation.Pokemon.Pokemon;
import Simulation.Settings.*;
import Simulation.Trainer.Trainer;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //ALL VARIABLES IN SIMULATION
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static ArrayList<Pokemon> arrayOfPokemons = new ArrayList<>();
    static int levelOfDeletedPokemon = 0;
    static int howManyPokemonsOffTheMap = 0;
    static String typeOfDeletedPokemon;
    static String typeOfDeletedPokemonsField;
    static Random rand = new Random();
    static String WATER = "W";
    static String FIRE = "F";
    static String GROUND = "G";
    static String GRASS = "g";
    static int howManyRounds = 0;
    private static boolean WinByKillingEverything = false;
    private static boolean WinByLevel = false;
    private static boolean Defeat = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static int currentStateCount = 1;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //STARTING SIMULATION
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void start(Field[][] flatMap, Trainer trainer) {
        arrayOfPokemons.clear();
        fillMap(flatMap);
        clearingMapAndTrainer(flatMap,trainer);
        generateMapFields(flatMap);
        System.out.println("Where are the special fields on the map:");
        printMap(flatMap);
        generatingTrainerOnTheMap(flatMap, trainer);
        generatingPokemons(flatMap);
        printCurrentSimulationState(flatMap);
        //WHOLE SIMULATION PROCESS
        do{
            trainer.moveTrainer(flatMap, arrayOfPokemons);

            if(pokemonRemover(flatMap, trainer)){
                if (trainer.catchPokemon(getLevelOfDeletedPokemon())){
                    trainer.giveExperience(2);
                    System.out.println("Pokemon has been caught.");
                }
                else if(trainer.fight(getLevelOfDeletedPokemon(), getTypeOfDeletedPokemon(), getTypeOfDeletedPokemonsField(), flatMap)) {
                    trainer.giveExperience(1);
                    System.out.println("Pokemon has been killed.");
                } else {
                    trainer.setHowManyBattlesLost(trainer.getHowManyBattlesLost() + 1);
                    System.out.println("Trainer has lost the battle.");
                }
            }
            trainer.levelUp();

            for(Pokemon pox : arrayOfPokemons) {
                pox.movePokemon(flatMap, trainer);
            }

            printCurrentSimulationState(flatMap);
            currentStateCount++;
            howManyRounds++;

        } while (trainer.checkingProgress() && !(arrayOfPokemons.isEmpty()));

        if (trainer.getHowManyBattlesLost() >= 3)  Defeat = true;
        if (trainer.getLevelOfPokemonTrainer()>=4) WinByLevel = true;
        if(arrayOfPokemons.isEmpty()) WinByKillingEverything = true;
        if(Settings.getSavingOptionChoice()==1) Saving.SaveToFileOnlyNumbers(trainer);
        if (Settings.getSavingOptionChoice()==2) Saving.SaveToFile(trainer);
        System.out.println();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //REMOVING POKEMON AFTER FIGHTING/CATCHING HIM AND GETTING HIS LEVEL AND TYPE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static boolean pokemonRemover(Field[][] flatMap, Trainer trainer) {
        for (int i = 0; i < arrayOfPokemons.size(); i++) {
            if (arrayOfPokemons.get(i).getYposition() == trainer.getYposition() && arrayOfPokemons.get(i).getXposition() == trainer.getXposition()) {
                flatMap[arrayOfPokemons.get(i).getYposition()][arrayOfPokemons.get(i).getXposition()].setOccupied(false);
                setLevelOfDeletedPokemon(arrayOfPokemons.get(i).getLevel());
                setTypeOfDeletedPokemon(arrayOfPokemons.get(i).getPokemonType());
                setTypeOfDeletedPokemonsField(flatMap[arrayOfPokemons.get(i).getYposition()][arrayOfPokemons.get(i).getXposition()].getFieldType());
                arrayOfPokemons.get(i).setYposition(-100);
                arrayOfPokemons.get(i).setXposition(-100);
                arrayOfPokemons.remove(i);
                howManyPokemonsOffTheMap++;
                Trainer.setHowManyPokemonsKilled2(Trainer.getHowManyPokemonsKilled2()+1);
                return true;
            }
        }
        return false;
    }


    public static void clearingMapAndTrainer(Field[][] flatMap, Trainer trainer) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j].setFieldType(".");
                flatMap[i][j].setOccupied(false);
                flatMap[i][j].setOccupiedByTrainer(false);
            }
        }
        trainer.setXposition(0);
        trainer.setYposition(0);
        trainer.setHowManyBattlesLost(0);
        trainer.setLevelOfPokemonTrainer(1);
        trainer.setHowManyPokemonsKilled(0);
        setDefeat(false);
        setWinByLevel(false);
        setWinByKillingEverything(false);

    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PRINTING MAP WITH FIELD TYPES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void printMap(Field[][] flatMap) {
        //System.out.println("\nACTUAL MAP3");
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                System.out.print(flatMap[i][j].fieldType + " ");
            }
            if (i==0) System.out.print("   W - water field");
            if (i==1) System.out.print("   F - fire field");
            if (i==2) System.out.print("   G - grass field");
            if (i==3) System.out.print("   g - ground field");
            System.out.println();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //PRINTING CURRENT SIMULATION STATE
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void printCurrentSimulationState(Field[][] flatMap) {
        System.out.println("\nCURRENT STATE " + Simulation.currentStateCount);
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                if (flatMap[i][j].isOccupiedByTrainer() && flatMap[i][j].isOccupied()) {
                    System.out.print("D ");
                } else
                if (flatMap[i][j].isOccupiedByTrainer() && !flatMap[i][j].isOccupied()) {
                    System.out.print("T ");
                } else if(flatMap[i][j].isOccupied() && !flatMap[i][j].isOccupiedByTrainer()) {
                    if(flatMap[i][j].getPokemonTypeOnField().equals("F")) {
                        System.out.print(ANSI_RED + "P " +ANSI_RESET);
                    }

                    if(flatMap[i][j].getPokemonTypeOnField().equals("W")) {
                        System.out.print(ANSI_BLUE + "P " +ANSI_RESET);
                    }

                    if(flatMap[i][j].getPokemonTypeOnField().equals("G")) {
                        System.out.print(ANSI_GREEN + "P " +ANSI_RESET);
                    }

                    if(flatMap[i][j].getPokemonTypeOnField().equals("g")) {
                        System.out.print(ANSI_YELLOW + "P " +ANSI_RESET);
                    }




                } else {
                    System.out.print(". ");
                }
            }
            if (i==0) System.out.print(ANSI_RED + "  P - fire pokemon" +ANSI_RESET);
            if (i==1) System.out.print(ANSI_BLUE + "  P - water pokemon" +ANSI_RESET);
            if (i==2) System.out.print(ANSI_GREEN + "  P - grass pokemon" +ANSI_RESET);
            if (i==3) System.out.print(ANSI_YELLOW + "  P - ground pokemon" +ANSI_RESET);
            if (i==4) System.out.print("  T - trainer");

            System.out.println();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CREATING OUR MAP
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void fillMap(Field[][] flatMap) {
        for (int i = 0; i < Map.getH(); i++) {
            for (int j = 0; j < Map.getW(); j++) {
                flatMap[i][j] = new Field();
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GENERATING FIELD TYPES IN MAP
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GENERATING POKEMONS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
                flatMap[generatedI][generatedJ].setPokemonTypeOnField("W");
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
                Pokemon poks = new PokemonFire(rand.nextInt(3)+1, generatedJ, generatedI, "F");
                flatMap[generatedI][generatedJ].setOccupied(true);
                flatMap[generatedI][generatedJ].setPokemonTypeOnField("F");
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
                flatMap[generatedI][generatedJ].setPokemonTypeOnField("G");
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
                flatMap[generatedI][generatedJ].setPokemonTypeOnField("g");
                arrayOfPokemons.add(poks);
                createdPokemons++;
                actualNumberOfGrassPokemons--;
            }

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GENERATING TRAINER
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void generatingTrainerOnTheMap(Field[][] flatMap, Trainer trainer) {
        int generatedI;
        int generatedJ;
        generatedI = rand.nextInt(Map.getH());
        generatedJ = rand.nextInt(Map.getW());
        trainer.setXposition(generatedJ);
        trainer.setYposition(generatedI);
        flatMap[generatedI][generatedJ].setOccupiedByTrainer(true);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS FOR VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static int getLevelOfDeletedPokemon() {
        return levelOfDeletedPokemon;
    }
    public static void setLevelOfDeletedPokemon(int levelOfDeletedPokemon) {Simulation.levelOfDeletedPokemon = levelOfDeletedPokemon;}
    public static String getTypeOfDeletedPokemon() {return typeOfDeletedPokemon;}
    public static void setTypeOfDeletedPokemon(String typeOfDeletedPokemon){Simulation.typeOfDeletedPokemon=typeOfDeletedPokemon;}
    public static String getTypeOfDeletedPokemonsField(){return typeOfDeletedPokemonsField;}
    public static void setTypeOfDeletedPokemonsField(String typeOfDeletedPokemonsField){Simulation.typeOfDeletedPokemonsField=typeOfDeletedPokemonsField;}
    public static int getHowManyPokemonsOffTheMap() {return howManyPokemonsOffTheMap;}
    public static int getHowManyRounds () {return howManyRounds;}
    public static boolean isWinByLevel() {
        return WinByLevel;
    }

    public static void setWinByLevel(boolean winByLevel) {
        WinByLevel = winByLevel;
    }

    public static boolean isWinByKillingEverything() {
        return WinByKillingEverything;
    }

    public static void setWinByKillingEverything(boolean winByKillingEverything) {
        WinByKillingEverything = winByKillingEverything;
    }

    public static boolean isDefeat() {
        return Defeat;
    }

    public static void setDefeat(boolean defeat) {
        Defeat = defeat;
    }
}
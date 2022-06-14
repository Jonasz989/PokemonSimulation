package Simulation;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pokemon implements PokemonMethods{
    Random rand = new Random();
    int level;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    boolean isAlive = true;


    static int howManyPokemonsShouldBeOnTheMap = 12;
    public static int ID = 1;
    public int pokemonID;

    private static int CountOfPokemonsOnTheMap = 0;


    int currentX;
    int currentY;
    String pokemonType;
    @Override
    public String getPokemonType() {
        return pokemonType;
    }


    //constructor for the pokemon
    Pokemon (int level, int currentX, int currentY) {
        this.level = level;
        this.currentX = currentX;
        this.currentY = currentY;
        this.isAlive = false;
        pokemonID = ID++;
    }


    //getter and setter for how many pokemons should be on the map
    public static int getHowManyPokemonsShouldBeOnTheMap() {
        return howManyPokemonsShouldBeOnTheMap;
    }

    public static void setHowManyPokemonsShouldBeOnTheMap(int howManyPokemonsShouldBeOnTheMap) {
        Pokemon.howManyPokemonsShouldBeOnTheMap = howManyPokemonsShouldBeOnTheMap;
    }




    //getter and setter for the pokemon's id
    public static int getID() {
        return ID;
    }
    public int getPokemonID() {
        return pokemonID;
    }


    //getter and setter for the pokemon's x and y position
    public int getXposition() {
        return currentX;
    }
    public void setXposition(int currentX) {
        this.currentX = currentX;
    }
    public int getYposition() {
        return currentY;
    }
    public void setYposition(int currentY) {
        this.currentY = currentY;
    }


    //getter for the pokemon's level
    public int getLevel() {
        return level;
    }


    //variable, getter and setter for the pokemons' critical hit base chance
    static float pokemonsCriticalHitBaseChance = 0.01f;
    public static float getPokemonsCriticalHitBaseChance() {
        return pokemonsCriticalHitBaseChance;
    }
    public static void setPokemonsCriticalHitBaseChance(float newPokemonsCriticalHitBaseChance) {pokemonsCriticalHitBaseChance = newPokemonsCriticalHitBaseChance;}


    //getter for the count of pokemons on the map

    public static int getCountOfPokemonsOnTheMap() {
        return CountOfPokemonsOnTheMap;
    }

    public static void setCountOfPokemonsOnTheMap(int countOfPokemonsOnTheMap) {
        CountOfPokemonsOnTheMap = countOfPokemonsOnTheMap;
    }

    //method for the pokemons' movement
    public void movePokemon(Field[][] flatMap, Trainer trainer) {
        int verticalMove;
        int horizontalMove;



        if(this.getPokemonType().equals(flatMap[this.getYposition()][this.getXposition()].getFieldType())) {
            System.out.println("Staying (he's already on his special field)\n");
            return;
        }

            do {
                verticalMove = rand.nextInt(3) - 1;
                horizontalMove = rand.nextInt(3) - 1;
            }
            while (this.getXposition() + horizontalMove > Map.getW() - 1 || (this.getXposition() + horizontalMove) <= 0 || (this.getYposition() + verticalMove) > Map.getH() - 1 || (this.getYposition() + verticalMove) <= 0 || flatMap[this.getYposition() + verticalMove][this.getXposition() + horizontalMove].isOccupied());


            if ((this.getXposition() + horizontalMove) == trainer.getXposition() && (this.getYposition() + verticalMove) == trainer.getYposition()) {
                flatMap[this.getYposition()][this.getXposition()].setOccupied(false);

                System.out.print("Pokemon's fight with the trainer\n");


                return;
            }

                flatMap[this.getYposition()][this.getXposition()].setOccupied(false);
                this.setXposition(this.getXposition() + horizontalMove);
                this.setYposition(this.getYposition() + verticalMove);
                flatMap[this.getYposition()][this.getXposition()].setOccupied(true);

    }


    public static float theDifferenceInLevels(int trainerLevel, int pokemonLevel) {
        if (trainerLevel > pokemonLevel) {
            return (trainerLevel - pokemonLevel) * 10;
        }

        if (trainerLevel < pokemonLevel) {
            return (trainerLevel  - pokemonLevel) * 10;
        }
        return 0;
    }

    public float theDifferenceInFieldType(Field[][] flatMap, Trainer trainer) {
        String trainerFieldType = flatMap[trainer.getYposition()][trainer.getXposition()].getFieldType();
        String pokemonFieldType = flatMap[this.getYposition()][this.getXposition()].getFieldType();


        return 0;
    }

    public float theDifferenceInPokemonType(String trainerType) {
        String pokemonEnemyType = this.getPokemonType();

        if (trainerType.equals(pokemonEnemyType)) {
            return 0;
        }

        if (trainerType.equals("F")) {
            if (pokemonEnemyType.equals("W")) {
                return -5;
            }
            if (pokemonEnemyType.equals("g")) {
                return 5;
            }
        }

        if (trainerType.equals("W")) {
            if (pokemonEnemyType.equals("G")) {
                return -5;
            }
            if (pokemonEnemyType.equals("F")) {
                return 5;
            }
        }

        if (trainerType.equals("G")) {
            if (pokemonEnemyType.equals("g")) {
                return -5;
            }
            if (pokemonEnemyType.equals("W")) {
                return 5;
            }
        }

        if (trainerType.equals("g")) {
            if (pokemonEnemyType.equals("F")) {
                return -5;
            }
            if (pokemonEnemyType.equals("G")) {
                return 5;
            }
        }
        return 0;
    }


    public void pokemonGettingKilled(Field[][] flatMap) {
        this.setYposition(-1);
        this.setXposition(-1);

    }


    public static int getSumOfHowManyPokemonsThereShouldBe() {
        return PokemonGrass.getHowManyGrassPokemonsOnTheMap() + PokemonGround.getHowManyGroundPokemonsOnTheMap() + PokemonFire.getHowManyFirePokemonsOnTheMap() + PokemonWater.getHowManyWaterPokemonsOnTheMap();
    }

}
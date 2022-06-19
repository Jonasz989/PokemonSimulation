package Simulation.Pokemon;

import Simulation.Pokemon.FromPokemon.*;
import Simulation.Settings.Field;
import Simulation.Settings.Map;
import Simulation.Trainer.Trainer;

import java.util.Random;

public abstract class Pokemon implements PokemonMethods {

    Random rand = new Random();

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int howManyPokemonsShouldBeOnTheMap = 12;
    private static int CountOfPokemonsOnTheMap = 0;
    private static float pokemonsCriticalHitBaseChance = 0.01f;
    private int level;
    private int currentX;
    private int currentY;
    private String pokemonType;
    @Override
    public String getPokemonType() {
        return pokemonType;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CONTRUCTOR
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Pokemon (int level, int currentX, int currentY) {
        this.level = level;
        this.currentX = currentX;
        this.currentY = currentY;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //METHODS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //method for the pokemons' movement
    public void movePokemon(Field[][] flatMap, Trainer trainer) {
        int verticalMove;
        int horizontalMove;

        if(this.getPokemonType().equals(flatMap[this.getYposition()][this.getXposition()].getFieldType())) {
            //stay on the same position
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
            //MOVING
                flatMap[this.getYposition()][this.getXposition()].setOccupied(false);
                this.setXposition(this.getXposition() + horizontalMove);
                this.setYposition(this.getYposition() + verticalMove);
                flatMap[this.getYposition()][this.getXposition()].setOccupied(true);
        flatMap[this.getYposition()][this.getXposition()].setPokemonTypeOnField(getPokemonType());
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

    //DO ZAKODOWANIA
    public float theDifferenceInFieldType(Field[][] flatMap, Trainer trainer) {
        String trainerFieldType = flatMap[trainer.getYposition()][trainer.getXposition()].getFieldType();
        String pokemonFieldType = flatMap[this.getYposition()][this.getXposition()].getFieldType();
        return 0;
    }

    public float theDifferenceInPokemonType(String trainerType) {
        String fightingPokemonType = this.getPokemonType();

        if (trainerType.equals(fightingPokemonType)) {
            return 0;
        }
        if (trainerType.equals("F")) {
            if (fightingPokemonType.equals("W")) {
                return -5;
            }
            if (fightingPokemonType.equals("g")) {
                return 5;
            }
        }
        if (trainerType.equals("W")) {
            if (fightingPokemonType.equals("G")) {
                return -5;
            }
            if (fightingPokemonType.equals("F")) {
                return 5;
            }
        }
        if (trainerType.equals("G")) {
            if (fightingPokemonType.equals("g")) {
                return -5;
            }
            if (fightingPokemonType.equals("W")) {
                return 5;
            }
        }
        if (trainerType.equals("g")) {
            if (fightingPokemonType.equals("F")) {
                return -5;
            }
            if (fightingPokemonType.equals("G")) {
                return 5;
            }
        }
        return 0;
    }

    public static int getSumOfHowManyPokemonsThereShouldBe() {
        return PokemonGrass.getHowManyGrassPokemonsOnTheMap() + PokemonGround.getHowManyGroundPokemonsOnTheMap() + PokemonFire.getHowManyFirePokemonsOnTheMap() + PokemonWater.getHowManyWaterPokemonsOnTheMap();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int getHowManyPokemonsShouldBeOnTheMap() {
        return howManyPokemonsShouldBeOnTheMap;
    }
    public static void setHowManyPokemonsShouldBeOnTheMap(int newHowManyPokemonsShouldBeOnTheMap) {
        Pokemon.howManyPokemonsShouldBeOnTheMap = newHowManyPokemonsShouldBeOnTheMap;
    }
    public int getLevel() {
        return level;
    }
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
    public static int getCountOfPokemonsOnTheMap() {
        return CountOfPokemonsOnTheMap;
    }
    public static void setCountOfPokemonsOnTheMap(int countOfPokemonsOnTheMap) { CountOfPokemonsOnTheMap = countOfPokemonsOnTheMap; }
    public static float getPokemonsCriticalHitBaseChance() {
        return pokemonsCriticalHitBaseChance;
    }
    public static void setPokemonsCriticalHitBaseChance(float newPokemonsCriticalHitBaseChance) {
        Pokemon.pokemonsCriticalHitBaseChance = newPokemonsCriticalHitBaseChance;
    }
}
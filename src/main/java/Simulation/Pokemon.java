package Simulation;

import java.util.ArrayList;
import java.util.Random;

public abstract class Pokemon implements PokemonMethods{
    Random rand = new Random();
    int level;
    static int howManyPokemonsShouldBeOnTheMap = 10;
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
        pokemonID = ID++;
        CountOfPokemonsOnTheMap++;
    }


    //getter and setter for how many pokemons should be on the map
    public static int getHowManyPokemonsShouldBeOnTheMap() {
        return howManyPokemonsShouldBeOnTheMap;
    }
    public static void setHowManyPokemonsShouldBeOnTheMap(int howManyPokemonsShouldBeOnTheMap) {howManyPokemonsShouldBeOnTheMap = howManyPokemonsShouldBeOnTheMap;}


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
    public static int getCountOfPokemonOnTheMap(){
        return CountOfPokemonsOnTheMap;
    }


    //method for the pokemons' movement
    public void movePokemon(Field[][] flatMap, Trainer trainer) {
        int verticalMove;
        int horizontalMove;

        if(this.getPokemonType() == flatMap[this.getYposition()][this.getXposition()].getFieldType()) {
            System.out.println("Staying (he's already on his special field");
            return;
        }
        else{
            do {
                verticalMove = rand.nextInt(3) - 1;
                horizontalMove = rand.nextInt(3) - 1;
            }
            while (this.getXposition() + horizontalMove > Map.getW() - 1 || this.getXposition() + horizontalMove < 0 || this.getYposition() + verticalMove > Map.getH() - 1 || this.getYposition() + verticalMove < 0);

            if (flatMap[this.getXposition() + horizontalMove][this.getYposition() + verticalMove].isOccupied()) {
                System.out.println("No movement because chosen field was occupied");
                return;
            }

            if ((this.getXposition() + horizontalMove) == trainer.getXposition() && (this.getYposition() + verticalMove) == trainer.getYposition()) {
                System.out.print("Pokemon's fight with the trainer");
            }
            else {
                flatMap[this.getYposition()][this.getXposition()].setOccupied(false);
                this.setXposition(this.getXposition() + horizontalMove);
                this.setYposition(this.getYposition() + verticalMove);
                flatMap[this.getYposition()][this.getXposition()].setOccupied(true);
            }
        }
    }
}
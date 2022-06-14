package Simulation;

public class PokemonGrass extends Pokemon{

    static int howManyGrassPokemonsOnTheMap = 2;
    private String pokemonType;
    PokemonGrass (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well

    public static int getHowManyGrassPokemonsOnTheMap() {
        return howManyGrassPokemonsOnTheMap;
    }

    public static void setHowManyGrassPokemonsOnTheMap(int howManyGrassPokemonsOnTheMap) {
        PokemonGrass.howManyGrassPokemonsOnTheMap = howManyGrassPokemonsOnTheMap;
    }

    @Override
    public String getPokemonType() {
        return pokemonType;
    }
}


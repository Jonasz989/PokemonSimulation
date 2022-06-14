package Simulation;

public class PokemonWater extends Pokemon{



    static int howManyWaterPokemonsOnTheMap = 4;
    private String pokemonType = "GROUND";
    PokemonWater (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;

    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well

    public static int getHowManyWaterPokemonsOnTheMap() {
        return howManyWaterPokemonsOnTheMap;
    }

    public static void setHowManyWaterPokemonsOnTheMap(int howManyWaterPokemonsOnTheMap) {
        PokemonWater.howManyWaterPokemonsOnTheMap = howManyWaterPokemonsOnTheMap;
    }

    @Override
    public String getPokemonType() {
        return pokemonType;
    }
}


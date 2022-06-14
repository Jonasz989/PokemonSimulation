package Simulation;

public class PokemonWater extends Pokemon{
    static int howManyWaterPokemonsOnTheMap = 4;
    private String pokemonType = "GROUND";

    //constructor for creating PokemonWater
    PokemonWater (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;

    }

    //getter and setter for the count of water pokemons on the map
    public static int getHowManyWaterPokemonsOnTheMap() {
        return howManyWaterPokemonsOnTheMap;
    }
    public static void setHowManyWaterPokemonsOnTheMap(int howManyWaterPokemonsOnTheMap) {PokemonWater.howManyWaterPokemonsOnTheMap = howManyWaterPokemonsOnTheMap;}


    @Override
    public String getPokemonType() {
        return pokemonType;
    }
}


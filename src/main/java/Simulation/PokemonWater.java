package Simulation;

public class PokemonWater extends Pokemon{
    static int howManyWaterPokemonsOnTheMap = 4;
    final private String pokemonType;

    //constructor for creating PokemonWater
    PokemonWater (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
        Pokemon.setCountOfPokemonsOnTheMap(getCountOfPokemonsOnTheMap() + 1);
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


package Simulation;

public class PokemonGrass extends Pokemon{
    static int howManyGrassPokemonsOnTheMap = 2;
    private String pokemonType;

    //constructor for creating PokemonGrass
    PokemonGrass (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
        Pokemon.setCountOfPokemonsOnTheMap(getCountOfPokemonsOnTheMap() + 1);
    }

    //getter and setter for the count of grass pokemons on the map
    public static int getHowManyGrassPokemonsOnTheMap() {
        return howManyGrassPokemonsOnTheMap;
    }
    public static void setHowManyGrassPokemonsOnTheMap(int howManyGrassPokemonsOnTheMap) {PokemonGrass.howManyGrassPokemonsOnTheMap = howManyGrassPokemonsOnTheMap;}


    @Override
    public String getPokemonType() {
        return pokemonType;
    }
}


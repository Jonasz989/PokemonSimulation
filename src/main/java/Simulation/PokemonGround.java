package Simulation;

public class PokemonGround extends Pokemon{
    static int howManyGroundPokemonsOnTheMap = 2;
    final private String pokemonType;

    //constructor for creating PokemonGround
    PokemonGround (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
        Pokemon.setCountOfPokemonsOnTheMap(getCountOfPokemonsOnTheMap() + 1);
    }

    //getter and setter for the count of ground pokemons on the map
    public static int getHowManyGroundPokemonsOnTheMap() {
        return howManyGroundPokemonsOnTheMap;
    }
    public static void setHowManyGroundPokemonsOnTheMap(int howManyGroundPokemonsOnTheMap) {PokemonGround.howManyGroundPokemonsOnTheMap = howManyGroundPokemonsOnTheMap;}


    @Override
    public String getPokemonType() {
        return pokemonType;
    }
}

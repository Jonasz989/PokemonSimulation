package Simulation;

public class PokemonGround extends Pokemon{
    static int howManyGroundPokemonsOnTheMap = 2;
    private String pokemonType = "GROUND";

    //constructor for creating PokemonGround
    PokemonGround (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
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

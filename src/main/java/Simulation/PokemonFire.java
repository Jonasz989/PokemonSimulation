package Simulation;

public class PokemonFire extends Pokemon{
    private static int howManyFirePokemonsOnTheMap = 2;
    final private String pokemonType;


    //constructor for creating PokemonFire
    PokemonFire (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
        Pokemon.setCountOfPokemonsOnTheMap(getCountOfPokemonsOnTheMap() + 1);
    }


    //getter and setter for the count of fire pokemons on the map
    public static int getHowManyFirePokemonsOnTheMap() {
        return howManyFirePokemonsOnTheMap;
    }
    public static void setHowManyFirePokemonsOnTheMap(int howManyFirePokemonsOnTheMap) {PokemonFire.howManyFirePokemonsOnTheMap = howManyFirePokemonsOnTheMap;}


    @Override
    public String getPokemonType() {
        return pokemonType;
    }

}

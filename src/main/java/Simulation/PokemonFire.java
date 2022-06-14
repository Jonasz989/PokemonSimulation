package Simulation;

public class PokemonFire extends Pokemon{

    private static int howManyFirePokemonsOnTheMap = 2;
    private String pokemonType = "FIRE";
    PokemonFire (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well

    public static int getHowManyFirePokemonsOnTheMap() {
        return howManyFirePokemonsOnTheMap;
    }

    public static void setHowManyFirePokemonsOnTheMap(int howManyFirePokemonsOnTheMap) {
        PokemonFire.howManyFirePokemonsOnTheMap = howManyFirePokemonsOnTheMap;
    }

    @Override
    public String getPokemonType() {
        return pokemonType;
    }

}

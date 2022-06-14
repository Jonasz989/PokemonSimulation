package Simulation;

public class PokemonFire extends Pokemon{

    static int FirePokemonsOnTheMap = 2;
    private String pokemonType = "FIRE";
    PokemonFire (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getFirePokemonsOnTheMap(){
        return FirePokemonsOnTheMap;
    }

}

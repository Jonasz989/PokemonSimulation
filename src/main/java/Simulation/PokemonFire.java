package Simulation;

public class PokemonFire extends Pokemon{

    static int FirePokemonsOnTheMap = -1;
    PokemonFire () {
        level = 1;
        FirePokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getFirePokemonsOnTheMap(){
        return FirePokemonsOnTheMap;
    }

}

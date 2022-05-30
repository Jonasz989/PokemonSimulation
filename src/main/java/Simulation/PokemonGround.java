package Simulation;

public class PokemonGround extends Pokemon{

    static int GroundPokemonsOnTheMap = -1;
    PokemonGround () {
        level = 1;
        GroundPokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getGroundPokemonsOnTheMap(){
        return GroundPokemonsOnTheMap;
    }

}

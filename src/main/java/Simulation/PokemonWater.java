package Simulation;

public class PokemonWater extends Pokemon{

    static int WaterPokemonsOnTheMap = -1;
    PokemonWater () {
        level = 1;
        WaterPokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getWaterPokemonsOnTheMap(){
        return WaterPokemonsOnTheMap;
    }

}


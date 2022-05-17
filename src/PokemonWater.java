public class PokemonWater extends Pokemon{

    int WaterPokemonsOnTheMap = -1;
    PokemonWater () {
        level = 1;
        WaterPokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public int getWaterPokemonsOnTheMap(){
        return WaterPokemonsOnTheMap;
    }

}

public class PokemonGrass extends Pokemon{
    int GrassPokemonsOnTheMap = -1;
    PokemonGrass () {
        level = 1;
        GrassPokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public int getGrassPokemonsOnTheMap(){
        return GrassPokemonsOnTheMap;
    }
}

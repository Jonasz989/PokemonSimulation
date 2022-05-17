public class PokemonFire extends Pokemon{

    int FirePokemonsOnTheMap = -1;
    PokemonFire () {
        level = 1;
        FirePokemonsOnTheMap++;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public int getFirePokemonsOnTheMap(){
        return FirePokemonsOnTheMap;
    }

}

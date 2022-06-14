package Simulation;

public class PokemonGrass extends Pokemon{
    static int GrassPokemonsOnTheMap = 2;
    private String pokemonType = "GRASS";
    PokemonGrass (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getGrassPokemonsOnTheMap(){
        return GrassPokemonsOnTheMap;
    }
}


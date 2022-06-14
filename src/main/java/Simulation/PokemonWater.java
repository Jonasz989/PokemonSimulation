package Simulation;

public class PokemonWater extends Pokemon{

    static int WaterPokemonsOnTheMap = 4;
    private String pokemonType = "GROUND";
    PokemonWater (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;

    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getWaterPokemonsOnTheMap(){
        return WaterPokemonsOnTheMap;
    }

}


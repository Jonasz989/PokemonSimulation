package Simulation;

public class PokemonGround extends Pokemon{

    static int GroundPokemonsOnTheMap = 2;
    private String pokemonType = "GROUND";
    PokemonGround (int level, int currentX, int currentY, String pokemonType) {
        super(level, currentX, currentY);
        this.pokemonType = pokemonType;
    }

    //variable for the count of fire type pokemons on the map, getter and setter for it as well
    public static int getGroundPokemonsOnTheMap(){
        return GroundPokemonsOnTheMap;
    }

}

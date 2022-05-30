package Simulation;

public class Pokemon {

    int level;
    static int CountOfPokemonsOnTheMap = -1;
    Pokemon () {
        level = 1;
        CountOfPokemonsOnTheMap++;
    }

    Pokemon (int level) {
        this.level = level;
    }

    //variable for Base Critical Hit Chance for the other pokemons, getter and setter for it as well
    static float pokemonsCriticalHitBaseChance = 0;
    float newPokemonsCriticalHitBaseChance=0;
    public static float getPokemonsCriticalHitBaseChance() {
        return pokemonsCriticalHitBaseChance;
    }
    public float setPokemonsCriticalHitBaseChance(float newPokemonsCriticalHitBaseChance) {
        return pokemonsCriticalHitBaseChance = newPokemonsCriticalHitBaseChance;
    }

    //variable for the count of pokemons on the map, getter and setter for it as well
    public static int getCountOfPokemonOnTheMap(){
        return CountOfPokemonsOnTheMap;
    }
}


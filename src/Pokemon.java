public class Pokemon extends Map {

    int level;
    int CountOfPokemonsOnTheMap = -1;
    Pokemon () {
        level = 1;
        CountOfPokemonsOnTheMap++;
    }

    Pokemon (int level) {
        this.level = level;
    }

    //variable for Base Critical Hit Chance for the other pokemons, getter and setter for it as well
    float pokemonsCriticalHitBaseChance = 0, newPokemonsCriticalHitBaseChance=0;
    public float getPokemonsCriticalHitBaseChance() {
        return pokemonsCriticalHitBaseChance;
    }
    public float setPokemonsCriticalHitBaseChance(float newPokemonsCriticalHitBaseChance) {
        return pokemonsCriticalHitBaseChance = newPokemonsCriticalHitBaseChance;
    }

    //variable for the count of pokemons on the map, getter and setter for it as well
    public int getCountOfPokemonOnTheMap(){
        return CountOfPokemonsOnTheMap;
    }
}

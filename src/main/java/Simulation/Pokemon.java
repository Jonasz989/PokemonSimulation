package Simulation;

public abstract class Pokemon {

    int level;

    public static int getHowManyPokemonsShouldBeOnTheMap() {
        return howManyPokemonsShouldBeOnTheMap;
    }

    public static void setHowManyPokemonsShouldBeOnTheMap(int howManyPokemonsShouldBeOnTheMap) {
        howManyPokemonsShouldBeOnTheMap = howManyPokemonsShouldBeOnTheMap;
    }

    static int howManyPokemonsShouldBeOnTheMap = 10;

    public static int getID() {
        return ID;
    }

    public static int ID = 1;

    public int getPokemonID() {
        return pokemonID;
    }

    public int pokemonID;
    private static int CountOfPokemonsOnTheMap = 0;
    public int getXposition() {
        return currentX;
    }

    public void setXposition(int currentX) {
        this.currentX = currentX;
    }
    int currentX;
    public int getYposition() {
        return currentY;
    }
    public void setYposition(int currentY) {
        this.currentY = currentY;
    }
    int currentY;

    public int getLevel() {
        return level;
    }


    String pokemonType;

    Pokemon (int level, int currentX, int currentY) {
        this.currentX = currentX;
        this.currentY = currentY;
        pokemonID = ID++;
        this.level = level;
        CountOfPokemonsOnTheMap++;
    }



    //variable for Base Critical Hit Chance for the other pokemons, getter and setter for it as well
    static float pokemonsCriticalHitBaseChance = 0.01f;
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


    public void movePokemon(Field[][] flatMap, Trainer trainer) {
        int verticalMove;
        int horizontalMove;
        if(this.pokemonType == flatMap[this.getYposition()][this.getXposition()].getFieldType()) {
            return;
        }
        do {
            verticalMove = rand.nextInt(3) - 1;
            horizontalMove = rand.nextInt(3) - 1;
        }
        while(this.getXposition() + horizontalMove > Map.getW() || this.getXposition() + horizontalMove < 0 || this.getYposition() + verticalMove > Map.getH() || this.getYposition() + verticalMove < 0 || flatMap[this.getXposition() + horizontalMove][this.getYposition() + verticalMove].isOccupied());


        if((this.getXposition() + horizontalMove) == Trainer.getXposition() && (this.getYposition() + verticalMove) == Trainer.getYposition()) {
            System.out.print("nastapila walka czy cos tam");
        } else {
            flatMap[this.getYposition()][this.getXposition()].setOccupied(false);
            this.setXposition(this.getXposition() + horizontalMove);
            this.setYposition(this.getYposition() + verticalMove);
            flatMap[this.getYposition()][this.getXposition()].setOccupied(true);
        }
    }

    //true if trainer wins, false if pokemon wins
    /*public boolean fight() {
        for (Pokemon pokemon : Simulation.arrayOfPokemons) {
            if(pokemon.getXposition()==trainer.getXposition() && pokemon.getYposition()==trainer.getYposition()){

                int TrainersLevelDifferenceChance = 0;
                if(trainer.getLevelofPokemonTrainer()-pokemon.getLevel()==2) TrainersLevelDifferenceChance = 20;
                if(trainer.getLevelofPokemonTrainer()-pokemon.getLevel()==1) TrainersLevelDifferenceChance = 10;
                if(trainer.getLevelofPokemonTrainer()-pokemon.getLevel()==-1) TrainersLevelDifferenceChance = -10;
                if(trainer.getLevelofPokemonTrainer()-pokemon.getLevel()==-2) TrainersLevelDifferenceChance = -20;

                int trainersChance = (int)(trainer.getTrainersWinningBaseChance()*100+trainer.getTrainersCriticalHitBaseChance()*100-pokemon.getPokemonsCriticalHitBaseChance()*100 + TrainersLevelDifferenceChance);
                int whoWon = rand.nextInt(99)+1;
                if (whoWon<=trainersChance) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }*/



}










































/*public void movingPokemonsThroughTheMap(Field[][] flatMap) {
        //1-right, 2-left, 3-top, 4-bottom
        for (Pokemon pokemon : Simulation.arrayOfPokemons) {
            if (flatMap[pokemon.getYposition()][pokemon.getXposition() + 1].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition()][pokemon.getXposition() + 1].isOccupied() ||
                    flatMap[pokemon.getYposition()][pokemon.getXposition() - 1].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition()][pokemon.getXposition() - 1].isOccupied() ||
                    flatMap[pokemon.getYposition() + 1][pokemon.getXposition()].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition() + 1][pokemon.getXposition()].isOccupied() ||
                    flatMap[pokemon.getYposition() - 1][pokemon.getXposition()].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition() - 1][pokemon.getXposition()].isOccupied()) {

                if (flatMap[pokemon.getYposition()][pokemon.getXposition() + 1].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition()][pokemon.getXposition() + 1].isOccupied()) {
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                    pokemon.setXposition(pokemon.getXposition() + 1);
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(true);
                } else if (flatMap[pokemon.getYposition()][pokemon.getXposition() - 1].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition()][pokemon.getXposition() - 1].isOccupied()) {
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                    pokemon.setXposition(pokemon.getXposition() + 1);
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(true);
                } else if (flatMap[pokemon.getYposition() + 1][pokemon.getXposition()].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition() + 1][pokemon.getXposition()].isOccupied()) {
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                    pokemon.setYposition(pokemon.getYposition() + 1);
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(true);
                } else if (flatMap[pokemon.getYposition() - 1][pokemon.getXposition()].fieldType == pokemon.pokemonType && !flatMap[pokemon.getYposition() - 1][pokemon.getXposition()].isOccupied()) {
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                    pokemon.setYposition(pokemon.getYposition() - 1);
                    flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(true);
                }
            } else {
                int[] directions = {1, 2, 3, 4};
                int generateDirection = rand.nextInt(directions.length + 1);
                switch (generateDirection) {
                    case 1:
                        if (pokemon.getXposition() < Map.getW() && !flatMap[pokemon.getYposition()][pokemon.getXposition() + 1].isOccupied()) {
                            flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                            pokemon.setXposition(pokemon.getXposition() + 1);
                            if (flatMap[pokemon.getYposition()][pokemon.getXposition()].isOccupiedByTrainer()) {
                                if (!fight()) {
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupied(true);
                                } else {
                                    //killingPokemon(Simulation.arrayOfPokemons);
                                }
                            }
                        }
                        break;
                    case 2:
                        if (pokemon.getXposition() > 0 && !flatMap[pokemon.getYposition()][pokemon.getXposition() - 1].isOccupied()) {
                            flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                            pokemon.setXposition(pokemon.getXposition() - 1);
                            if (flatMap[pokemon.getYposition()][pokemon.getXposition()].isOccupiedByTrainer()) {
                                if (!fight()) {
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupied(true);
                                } else {
                                   // killingPokemon(Simulation.arrayOfPokemons);
                                }
                            }
                        }
                        break;
                    case 3:
                        if (pokemon.getYposition() > 0 && !flatMap[pokemon.getYposition() - 1][pokemon.getXposition()].isOccupied()) {
                            flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                            pokemon.setYposition(pokemon.getYposition() - 1);
                            if (flatMap[pokemon.getYposition()][pokemon.getXposition()].isOccupiedByTrainer()) {
                                if (!fight()) {
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupied(true);
                                } else {
                                    //killingPokemon(Simulation.arrayOfPokemons);
                                }
                            }
                        }
                        break;
                    case 4:
                        if (pokemon.getYposition() < Map.getH() && !flatMap[pokemon.getYposition() + 1][Trainer.getXposition()].isOccupied()) {
                            flatMap[pokemon.getYposition()][pokemon.getXposition()].setOccupied(false);
                            pokemon.setYposition(pokemon.getYposition() + 1);
                            if (flatMap[pokemon.getYposition()][pokemon.getXposition()].isOccupiedByTrainer()) {
                                if (!fight()) {
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupiedByTrainer(false);
                                    flatMap[Trainer.getYposition()][Trainer.getXposition()].setOccupied(true);
                                } else {
                                    //killingPokemon(Simulation.arrayOfPokemons);
                                }
                            }
                        }
                        break;
                }
            }
        }
    }*/
package Simulation;
import Simulation.Pokemon.Pokemon;
import Simulation.Settings.Map;
import Simulation.Trainer.Trainer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Saving {
    static Scanner scanner = new Scanner(System.in);
    //height, width, special fields, pokemons count, trainer's chance of winning, how many pokemons left on the map,
    // how many pokemons killed, how many pokemons caught, how many rounds, what outcome (win/lose and wich type)
    public static void SaveToFileOnlyNumbers (){
        Trainer trainer = new Trainer(Trainer.getNameOfPokemonsTrainer(), Trainer.getTrainersWinningBaseChance(), Trainer.getTrainersCriticalHitBaseChance(), Trainer.getTypeOfTrainersPokemon());

        try{
            File file = new File("Results.txt");
            file.createNewFile();
            PrintWriter pw = new PrintWriter(file);
            pw.println(Map.getH());
            pw.println(Map.getW());
            pw.println(Map.getSumOfSpecialFields());
            pw.println(Pokemon.getHowManyPokemonsShouldBeOnTheMap());
            pw.println(Trainer.getTrainersWinningBaseChance());
            pw.println(Pokemon.getHowManyPokemonsShouldBeOnTheMap()-Simulation.getHowManyPokemonsOffTheMap());
            pw.println(Trainer.getHowManyPokemonsKilled2());
            pw.println(Trainer.getHowManyPokemonsCaught());
            pw.println(Simulation.getHowManyRounds());
            //defeat = 0, win by level = 1, win by killing everyone = 2
            if (Simulation.getDefeat()) pw.println(0);
            if (Simulation.getWinByLevel()) pw.println(1);
            if (Simulation.getWinByKillingEverything()) pw.println(2);
            pw.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void SaveToFile (){
        Trainer trainer = new Trainer(Trainer.getNameOfPokemonsTrainer(), Trainer.getTrainersWinningBaseChance(), Trainer.getTrainersCriticalHitBaseChance(), Trainer.getTypeOfTrainersPokemon());
        try{
        File file = new File("Results.txt");
        file.createNewFile();
        PrintWriter pw = new PrintWriter(file);
        pw.println("Map's height: " + Map.getH());
        pw.println("Map's width: " + Map.getW());
        pw.println("How many special fields on the map: " + Map.getSumOfSpecialFields());
        pw.println("How many pokemons should be on the map: " + Pokemon.getHowManyPokemonsShouldBeOnTheMap());
        pw.println("Trainer's winning base chance: " + Trainer.getTrainersWinningBaseChance());
        pw.println("How many pokemons left on the map: " + (Pokemon.getHowManyPokemonsShouldBeOnTheMap()-Simulation.getHowManyPokemonsOffTheMap()));
        pw.println("How many pokemons were killed: " + trainer.getHowManyPokemonsKilled2());
        pw.println("How many pokemons got caught: " + Trainer.getHowManyPokemonsCaught());
        pw.println("How many rounds were in the simulation: " + Simulation.getHowManyRounds());
        if (Trainer.getDefeat()){
            pw.println("Trainer lost");
        }
        else if (Trainer.getWinByLevel()) {
            pw.println("Trainer won by reaching 4. level");
        }
        else if (Simulation.getWinByKillingEverything()) {
            pw.println("Trainer won because of no more pokemons on the map");
        }
        pw.close();

    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public static void ReadFromFile (){
        try {
            File file = new File("Results.txt");
            Scanner sc = new Scanner(file);

            int i = 0;
            String separator = " ";
            String entireFile ="";
            while (sc.hasNextLine()) {
                entireFile = entireFile.concat(sc.nextLine()+" ");
            }
            String[] separated = entireFile.split(" ");
            Map.setH(Integer.parseInt(separated[0]));
            Map.setW(Integer.parseInt(separated[1]));
            Pokemon.setHowManyPokemonsShouldBeOnTheMap(Integer.parseInt(separated[3]));
            Trainer.setTrainersWinningBaseChance(Float.parseFloat(separated[4]));
            sc.close();

        }
        catch (Exception e){
            System.out.println("An Error occured.");
            e.printStackTrace();
        }
    }
}

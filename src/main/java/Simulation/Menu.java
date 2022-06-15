package Simulation;

import Simulation.Settings.*;
import Simulation.Trainer.Trainer;

import java.util.Scanner;
import java.lang.*;
public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String choiceMenu;
        while(true) {
            System.out.println("1. Start simulation");
            System.out.println("2. Show current settings");
            System.out.println("3. Change existing settings");
            System.out.println("0. Exit");
            choiceMenu = scanner.next();
            switch (choiceMenu) {
                case "1":
                    Field[][] flatMap = new Field[Map.getH()][Map.getW()];
                    Trainer trainer = new Trainer(Trainer.getNameOfPokemonsTrainer(), Trainer.getTrainersWinningBaseChance(), Trainer.getTrainersCriticalHitBaseChance(), Trainer.getTypeOfTrainersPokemon());
                    Simulation.start(flatMap, trainer);
                    break;
                case "2":
                    Settings.printSettings();
                    break;
                case "3":
                    Settings.changeSettings();
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("Your input was invalid. Please choose number 0-3.");
                    break;
            }
        }
    }
}

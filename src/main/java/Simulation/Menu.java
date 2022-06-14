package Simulation;

/*
 This program let us simulate a career of young Pokemon trainer
 In menu we can choose 1. Start simulation, 2. Setting 3. Exit*
 */
import java.util.Scanner;
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
                    Simulation essa = new Simulation();
                    essa.start(essa.flatMap);
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

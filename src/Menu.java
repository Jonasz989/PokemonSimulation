/**
This program let us simulate a career of young Pokemon trainer
In menu we can choose 1. Start simulation, 2. Setting 3. Exit*
 */
import java.util.Scanner;
public class Menu {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choiceMenu;
        Settings settings = new Settings();
        while(true) {
            System.out.println("1. Start simulation");
            System.out.println("2. Show current settings");
            System.out.println("3. Change existing settings");
            System.out.println("4. Exit");
            choiceMenu = scanner.nextInt();
            switch (choiceMenu) {
                case 1:
                    break;
                case 2:
                    settings.printSettings();
                    break;
                case 3:
                    settings.changeSettings();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Your input was invalid. Please choose number 1-4.");
                    break;

            }
        }
    }
}

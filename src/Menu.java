/**
This program let us simulate a career of young Pokemon trainer
In menu we can choose 1. Start simulation, 2. Setting 3. Exit*
 */
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int choiceMenu=0;
        Settings settings = new Settings();
        while (true) {
            while(true){
                System.out.println("1. Start simulation");
                System.out.println("2. Show current settings");
                System.out.println("3. Change existing settings");
                System.out.println("4. Exit");
                boolean test = scanner.hasNextInt();
                if(test){
                    choiceMenu = scanner.nextInt();
                    break;
                }
                else{
                    System.out.println("You've entered a String variable instead of an Integer. Please try again.");
                    System.out.println(" ");
                }
                scanner.nextLine();


            }
                switch (choiceMenu) {
                    case 1:
                        Simulation essa = new Simulation();
                        essa.start(essa.flatMap);
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

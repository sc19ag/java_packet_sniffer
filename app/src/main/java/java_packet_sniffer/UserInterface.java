package java_packet_sniffer;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc = new Scanner(System.in);
    
    public void printWelcomeMessage() {
        System.out.println("\nWelcome to a simple java-based packet sniffer.");
    }
    
    public void doMainMenu() {
        int choice = 0;
        
        while(choice != 4) {
            System.out.println("\nPlease type the number of your choice:\n");
            System.out.println("1. Print packet details to the console");
            System.out.println("2. Print packet details to a file");
            System.out.println("3. Do both of the above");
            System.out.println("4. Exit the application");

            choice = this.sc.nextInt();

            switch(choice) {
                case 1:
                this.printToConsole();
                break;

                case 2:
                this.doFileSelectMenu();
                break;

                case 3:
                this.doFileSelectMenu();
                this.printToConsole();
                break;

                case 4:
                System.out.println("\nBye!");
                this.sc.close();
                System.exit(0);

                default:
                System.err.println("\nError: Invalid option");
                break;
            }
        }
    }

    private void doFileSelectMenu() {
        int subChoice = 0;
        String filePath;
        
        System.out.println("\nPlease type the number of your choice:\n");
        System.out.println("1. Enter file path");
        System.out.println("2. Main menu");

        subChoice = this.sc.nextInt();
        // todo: change this to if-else block
        switch(subChoice) {
            case 1:
            System.out.println("Please write the path of the file you wish to print to:");
            this.sc.nextLine();
            filePath = this.sc.nextLine();
            this.printToFile(filePath);
            // todo: figure out how you can check if a file path leads to an actual file when that file path
            // is a string
            // note: could use a loop to ensure only this menu continues repeating until the file is correct
            /* 
            try {
                filePath = sc.nextLine();
            } catch(FileNotFoundException e) {
                System.err.println(e); // todo: print e in the most concise form, there is an attribute/method 
                                        //  that can be called on e
            }
            */
            break;

            case 2:
            this.doMainMenu();
            break;

            default:
            System.err.println("Error: Invalid option");
            doFileSelectMenu();
            break;
        }
    }

    private void printToConsole() {
        System.out.println("printToConsole() called");
    }

    private void printToFile(String path) {
        System.out.println("printToFile() called with filepath " + path);
    }
}

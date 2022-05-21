package offline_1;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Application {

    private static Scanner scanner;
    private

    public static void main( String[] args ) {

        scanner = new Scanner(System.in);
        Bank bank = Bank.getInstance();

        processInputs();
    }

    private static void processInputs() {
        System.out.print("Please enter your command: ");
        String command = scanner.nextLine();
        decideCommand(command);
    }

    private static void decideCommand( String command ) {
        if (command.contains("Create"))
            System.out.println(CommandProcessor.createNewAccount(command));
    }

}

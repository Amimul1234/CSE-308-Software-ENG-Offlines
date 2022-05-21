package offline_1;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Application {

    private static CommandProcessor commandProcessor;
    private static Scanner scanner;

    public static void main( String[] args ) {

        Bank bank = Bank.getInstance();
        scanner = new Scanner(System.in);
        commandProcessor = new CommandProcessor();

        processInputs();
    }

    private static void processInputs() {
        System.out.print("Please enter your command: ");
        String command = scanner.nextLine();
        decideCommand(command);
        processInputs();
    }

    private static void decideCommand( String command ) {
        if (command.contains("Create"))
            System.out.println(commandProcessor.createNewAccount(command));
        else if (command.contains("Deposit"))
            System.out.println(commandProcessor.depositToAccount(command));
        else if (command.contains("Withdraw"))
            System.out.println(commandProcessor.withDrawAmount(command));
        else if (command.contains("Query"))
            System.out.println(commandProcessor.queryForAmount());
        else if(command.contains("Request"))
            System.out.println(commandProcessor.requestForLoan(command));
        else if(command.contains("Close"))
            System.out.println(commandProcessor.closeCurrentSession());
    }

}

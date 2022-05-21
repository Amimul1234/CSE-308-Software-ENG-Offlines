package offline_1;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Application {

    private static Bank bank;
    private static Scanner scanner;
    private static CommandProcessorForAccount commandProcessorForAccount;

    public static void main( String[] args ) {

        bank = Bank.getInstance();
        scanner = new Scanner(System.in);
        commandProcessorForAccount = new CommandProcessorForAccount();

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
            openSessionForAccounts(command);
        else if (command.contains("Open"))
            decideSession(command);
    }

    //TODO: Decide for whom session should be opned.
    private static void decideSession( String command ) {

    }

    private static void openSessionForAccounts( String command ) {
        if (command.contains("Create"))
            System.out.println(commandProcessorForAccount.createNewAccount(command));
        else if (command.contains("Deposit"))
            System.out.println(commandProcessorForAccount.depositToAccount(command));
        else if (command.contains("Withdraw"))
            System.out.println(commandProcessorForAccount.withDrawAmount(command));
        else if (command.contains("Query"))
            System.out.println(commandProcessorForAccount.queryForAmount());
        else if (command.contains("Request"))
            System.out.println(commandProcessorForAccount.requestForLoan(command));
        else if (command.contains("Close"))
            System.out.println(commandProcessorForAccount.closeCurrentSession());
    }
}

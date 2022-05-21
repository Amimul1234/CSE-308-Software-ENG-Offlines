package offline_1;

import offline_1.account.domain.Account;
import offline_1.employee.domain.Employee;

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
        if (command.contains("Open"))
            decideSession(command);
        else
            openSessionForAccounts(command);

    }

    //TODO: complete session for employees
    private static void decideSession( String command ) {

        String[] s = command.split(" ");
        Object session = bank.decideSession(s[1]);

        if (session instanceof Account) {
            commandProcessorForAccount.openSession((Account) session);
        } else if (session instanceof Employee) {

        } else {
            System.out.println(session.toString());
        }
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

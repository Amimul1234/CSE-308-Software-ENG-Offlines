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
    private static CommandProcessorForEmployees commandProcessorForEmployees;

    public static void main( String[] args ) {

        bank = Bank.getInstance();
        scanner = new Scanner(System.in);
        commandProcessorForAccount = new CommandProcessorForAccount();
        commandProcessorForEmployees = new CommandProcessorForEmployees();

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
        if (commandProcessorForEmployees.checkIfSessionActive())
            openSessionForEmployees(command);
        else
            openSessionForAccounts(command);
    }

    private static void decideSession( String command ) {

        String[] s = command.split(" ");
        Object session = bank.decideSession(s[1]);

        if (session instanceof Account) {
            commandProcessorForAccount.openSession((Account) session);
        } else if (session instanceof Employee) {
            System.out.println(commandProcessorForEmployees.openSession((Employee) session));
            openSessionForEmployees(command);
        } else {
            System.out.println(session.toString());
        }
    }

    private static void openSessionForEmployees( String command ) {
        if (command.contains("Approve"))
            commandProcessorForEmployees.approveLoan();
        else if (command.contains("Change"))
            System.out.println(commandProcessorForEmployees.changeInterestRate(command));
        else if (command.contains("Lookup"))
            System.out.println(commandProcessorForEmployees.lookUpForAccount(command));
        else if (command.contains("See"))
            System.out.println(commandProcessorForEmployees.seeInternalFunding());
        else if (command.contains("INC"))
            System.out.println(commandProcessorForEmployees.incrementCurrentYear());
        else if (command.contains("Close"))
            System.out.println(commandProcessorForEmployees.closeSession());
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

package offline_1;

import offline_1.account.constants.AccountType;
import offline_1.account.domain.Account;
import offline_1.account.services.*;
import offline_1.account.services.imp.*;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CommandProcessorForAccount {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private String userName;
    private final Bank bank;
    private final DepositService depositService;
    private final WithDrawService withDrawService;
    private final QueryDepositService queryDepositService;
    private final LoanService loanService;
    private final CreateAccountService createAccountService;

    public CommandProcessorForAccount() {
        bank = Bank.getInstance();

        loanService = new LoanServiceImp();
        withDrawService = new WithDrawServiceImp();
        depositService = new DepositServiceAmountImp();
        queryDepositService = new QueryDepositServiceImp();
        createAccountService = new CreateAccountServiceImp();
    }

    public String createNewAccount( String command ) {

        String[] s = command.split(" ");

        String userName = s[1];
        String accountType = s[2];
        String amount = s[3];

        AccountType accountType1 = decideAccountType(accountType);
        this.userName = userName;

        try {
            return createAccountService.createNewAccount(userName, accountType1, Double.parseDouble(amount));
        } catch (Exception exception) {
            userName = null;
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not create account. Exception occurred";
        }
    }

    public String depositToAccount( String command ) {

        String[] s = command.split(" ");
        Account account = bank.checkForAccountUsingUserName(userName);

        try {
            return depositService.depositToAccount(account, Double.parseDouble(s[1]));
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not deposit from account. Exception occurred";
        }
    }

    public String withDrawAmount( String command ) {

        String[] s = command.split(" ");
        Account account = bank.checkForAccountUsingUserName(userName);

        try {
            return withDrawService.withDrawFromAccount(account, Double.parseDouble(s[1]));
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not withdraw from account. Exception occurred";
        }
    }

    public String queryForAmount() {

        Account account = bank.checkForAccountUsingUserName(userName);

        try {
            return queryDepositService.queryDepositAmount(account);
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not query from account. Exception occurred";
        }
    }

    public String requestForLoan( String command ) {

        String[] s = command.split(" ");
        Account account = bank.checkForAccountUsingUserName(userName);

        try {
            return loanService.loanRequest(account, Double.parseDouble(s[1]));
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not request for loan. Exception occurred";
        }
    }

    public void openSession( Account account ) {
        System.out.println("Welcom back, " + account.getUserName());
        this.userName = account.getUserName();
    }

    private AccountType decideAccountType( String accountType ) {
        if (accountType.equalsIgnoreCase("Student"))
            return AccountType.STUDENT;
        else if (accountType.equalsIgnoreCase("Savings"))
            return AccountType.SAVINGS;
        else if (accountType.equalsIgnoreCase("Loan"))
            return AccountType.LOAN;
        else if (accountType.equalsIgnoreCase("Fixed DepositService"))
            return AccountType.FIXED_DEPOSIT;
        else
            throw new RuntimeException("No such account type exists");
    }

    public String closeCurrentSession() {
        String name = userName;
        userName = null;
        return "Transaction closed for " + name;
    }
}

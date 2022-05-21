package offline_1.account.services.imp;

import offline_1.Bank;
import offline_1.account.Account;
import offline_1.account.AccountType;
import offline_1.account.services.CreateAccount;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CreateAccountImp implements CreateAccount {

    private final Bank bank = Bank.getInstance();

    @Override
    public String createNewAccount( String userName, AccountType accountType, Double initialDeposit ) {

        int result = bank.checkForAccountUsingUserName(userName);

        if (result == 1) {
            return "Bank account already exists for user : " + userName;
        } else {
            return checkForAccountCreationCondition(userName, accountType, initialDeposit);
        }
    }

    private String checkForAccountCreationCondition( String userName, AccountType accountType, Double initialDeposit ) {

        Account account = new Account();

        if (initialDeposit < 0)
            return "Initial deposit can not be negative";
        else if (accountType == AccountType.FIXED_DEPOSIT && initialDeposit < 100000)
            return "Fixed deposit account can not have initial deposit less then 100,000$";

        if (accountType == AccountType.LOAN)
            account.setUserName(userName)
                    .setAccountAge(0)
                    .setAccountType(accountType)
                    .setLoan(initialDeposit)
                    .setDepositAmount(0.0);
        else
            account.setUserName(userName)
                    .setAccountAge(0)
                    .setAccountType(accountType)
                    .setLoan(0.0)
                    .setDepositAmount(initialDeposit);

        return bank.addNewAccountToBank(account);
    }
}

package offline_1;

import offline_1.account.Account;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Bank {

    private Double totalBankBalance;
    private static Bank bank;
    private final List<Account> accountList;

    public static Bank getInstance() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    public Bank() {
        accountList = new LinkedList<>();
    }

    public String addNewAccountToBank( Account account ) {
        accountList.add(account);
        bank.setTotalBankBalance(bank.getTotalBankBalance() + account.getTotalAmount());

        return account.getAccountType().getAccountType() + " account for " + account.getUserName() + " Created; initial balance "
                + account.getTotalAmount() + "$";
    }

    public int checkForAccountUsingUserName( String userName ) {

        for (Account account : accountList) {
            if (account.getUserName().equals(userName))
                return 1;
        }

        return -1;
    }

    public Double getTotalBankBalance() {
        return totalBankBalance;
    }

    public void setTotalBankBalance( Double totalBankBalance ) {
        this.totalBankBalance = totalBankBalance;
    }
}

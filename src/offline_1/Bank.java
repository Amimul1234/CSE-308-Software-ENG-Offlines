package offline_1;

import offline_1.account.Account;
import offline_1.account.LoanRequest;
import offline_1.employee.Employee;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Bank {

    private Double totalBankBalance;
    private Double totalLoan;
    private static Bank bank;
    private final List<Employee> employeeList;
    private final List<Account> accountList;
    private final List<LoanRequest> loanRequestList;

    public static Bank getInstance() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    public Bank() {
        totalBankBalance = 1000000.0;
        totalLoan = 0.0;
        accountList = new LinkedList<>();
        employeeList = new LinkedList<>();
        loanRequestList = new LinkedList<>();
    }

    public String addNewAccountToBank( Account account ) {

        accountList.add(account);
        bank.setTotalBankBalance(bank.getTotalBankBalance() + account.getDepositAmount());

        return account.getAccountType().getAccountType() + " account for " + account.getUserName() + " Created; initial balance "
                + account.getDepositAmount() + "$";
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

    public Double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan( Double totalLoan ) {
        this.totalLoan = totalLoan;
    }

    public void addLoanRequest( LoanRequest loanRequest ) {
        loanRequestList.add(loanRequest);
    }
}

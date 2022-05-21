package offline_1;

import offline_1.account.Account;
import offline_1.account.LoanRequest;
import offline_1.employee.Employee;
import offline_1.employee.EmployeeFactory;
import offline_1.employee.EmployeeType;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Bank {

    private static Bank bank;
    private Double totalLoan;
    private Double totalBankBalance;
    private EmployeeFactory employeeFactory;
    private final List<Account> accountList;
    private final List<Employee> employeeList;
    private final List<LoanRequest> loanRequestList;

    public static Bank getInstance() {
        if (bank == null)
            bank = new Bank();

        return bank;
    }

    public Bank() {
        totalBankBalance = 1000000.0;
        totalLoan = 0.0;
        employeeFactory = new EmployeeFactory();
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

    public String createEmployee( EmployeeType employeeType ) {
        employeeList.add(employeeFactory.createEmployee(employeeType));
        return employeeType.getEmployeeType();
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

    public static Bank getBank() {
        return bank;
    }

    public static void setBank( Bank bank ) {
        Bank.bank = bank;
    }

    public EmployeeFactory getEmployeeFactory() {
        return employeeFactory;
    }

    public void setEmployeeFactory( EmployeeFactory employeeFactory ) {
        this.employeeFactory = employeeFactory;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<LoanRequest> getLoanRequestList() {
        return loanRequestList;
    }
}

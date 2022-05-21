package offline_1;

import offline_1.account.domain.Account;
import offline_1.account.domain.LoanRequest;
import offline_1.employee.domain.Employee;
import offline_1.employee.factory.EmployeeFactory;
import offline_1.employee.constants.EmployeeType;

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

    private Bank() {

        totalLoan = 0.0;
        totalBankBalance = 1000000.0;

        employeeFactory = new EmployeeFactory();
        accountList = new LinkedList<>();
        employeeList = new LinkedList<>();
        loanRequestList = new LinkedList<>();

        String employeeInstantiation = populateEmployees();

        System.out.println("Bank Created; " + employeeInstantiation);
    }

    public String addNewAccountToBank( Account account ) {

        accountList.add(account);
        bank.setTotalBankBalance(bank.getTotalBankBalance() + account.getDepositAmount());

        return account.getAccountType().getAccountType() + " account for " + account.getUserName() + " Created; initial balance "
                + account.getDepositAmount() + "$";
    }

    public String addNewEmployee( String employeeName, EmployeeType employeeType ) {
        employeeList.add(employeeFactory.createEmployee(employeeName, employeeType));
        return employeeName;
    }

    private String populateEmployees() {

        String m_d = addNewEmployee("M D", EmployeeType.MANAGING_DIRECTOR);

        String o1 = addNewEmployee("O1", EmployeeType.OFFICER);
        String o2 = addNewEmployee("O2", EmployeeType.OFFICER);

        String c1 = addNewEmployee("C1", EmployeeType.CASHIER);
        String c2 = addNewEmployee("C2", EmployeeType.CASHIER);
        String c3 = addNewEmployee("C3", EmployeeType.CASHIER);
        String c4 = addNewEmployee("C4", EmployeeType.CASHIER);
        String c5 = addNewEmployee("C5", EmployeeType.CASHIER);

        return m_d + ", " + o1 + ", " + o2 + ", " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", " + c5 + " created";
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

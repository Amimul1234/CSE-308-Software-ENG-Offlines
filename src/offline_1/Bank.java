package offline_1;

import offline_1.account.constants.AccountType;
import offline_1.account.domain.Account;
import offline_1.account.domain.LoanRequest;
import offline_1.employee.constants.EmployeeType;
import offline_1.employee.domain.Employee;
import offline_1.employee.factory.EmployeeFactory;
import offline_1.util.AsciiArtGenerator;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Bank {

    private static Bank bank;
    private Double totalLoan;
    private Integer currentYear;
    private Double totalBankBalance;
    private final InterestRate interestRate;
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

        new AsciiArtGenerator();

        totalLoan = 0.0;
        currentYear = 0;
        totalBankBalance = 1000000.0;

        interestRate = new InterestRate();
        employeeFactory = new EmployeeFactory();
        accountList = new LinkedList<>();
        employeeList = new LinkedList<>();
        loanRequestList = new LinkedList<>();

        String employeeInstantiation = populateEmployees();

        System.out.println("Bank Created; " + employeeInstantiation);
    }

    public String addNewAccountToBank( Account account ) {

        accountList.add(account);

        if (account.getAccountType() != AccountType.LOAN)
            bank.setTotalBankBalance(bank.getTotalBankBalance() + account.getDepositAmount());
        else
            bank.setTotalLoan(bank.getTotalLoan() + account.getLoan());

        return account.getAccountType().getAccountType() + " account for " + account.getUserName() + " Created; initial balance "
                + account.getDepositAmount() + "$";
    }

    public String addNewEmployee( String employeeName, EmployeeType employeeType ) {
        employeeList.add(employeeFactory.createEmployee(employeeName, employeeType));
        return employeeName;
    }

    private String populateEmployees() {

        String md = addNewEmployee("MD", EmployeeType.MANAGING_DIRECTOR);

        String s1 = addNewEmployee("S1", EmployeeType.OFFICER);
        String s2 = addNewEmployee("S2", EmployeeType.OFFICER);

        String c1 = addNewEmployee("C1", EmployeeType.CASHIER);
        String c2 = addNewEmployee("C2", EmployeeType.CASHIER);
        String c3 = addNewEmployee("C3", EmployeeType.CASHIER);
        String c4 = addNewEmployee("C4", EmployeeType.CASHIER);
        String c5 = addNewEmployee("C5", EmployeeType.CASHIER);

        return md + ", " + s1 + ", " + s2 + ", " + c1 + ", " + c2 + ", " + c3 + ", " + c4 + ", " + c5 + " created";
    }

    public Account checkForAccountUsingUserName( String userName ) {

        for (Account account : accountList) {
            if (account.getUserName().equals(userName))
                return account;
        }

        return null;
    }

    public Object decideSession( String userName ) {

        Optional<Employee> employeeOptional = employeeList.stream()
                .filter(employee -> employee.getEmployeeName().equals(userName))
                .findFirst();

        if (employeeOptional.isPresent())
            return employeeOptional.get();

        Optional<Account> accountOptional = accountList.stream().filter(account -> account.getUserName().equals(userName))
                .findFirst();

        if (accountOptional.isPresent())
            return accountOptional.get();

        return "User is neither employee nor account holder";
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

    public Integer getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear( Integer currentYear ) {
        this.currentYear = currentYear;
    }

    public InterestRate getInterestRate() {
        return interestRate;
    }

    public void changeInterestRate( AccountType accountType, Double newInterestRate ) {

        if (accountType == AccountType.STUDENT)
            bank.interestRate.setStudentAccountInterestRate(newInterestRate);
        else if (accountType == AccountType.SAVINGS)
            bank.interestRate.setSavingsAccountInterestRate(newInterestRate);
        else if (accountType == AccountType.FIXED_DEPOSIT)
            bank.interestRate.setFixedDepositInterestRate(newInterestRate);
        else
            System.out.println("Can not change interest rate for the account");
    }
}

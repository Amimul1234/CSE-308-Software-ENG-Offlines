package offline_1.account;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Account {

    private String userName;
    private AccountType accountType;
    private Double totalAmount;
    private Double loan;

    public Account( String userName, AccountType accountType, Double totalAmount, Double loan ) {
        this.userName = userName;
        this.accountType = accountType;
        this.totalAmount = totalAmount;
        this.loan = loan;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType( AccountType accountType ) {
        this.accountType = accountType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount( Double totalAmount ) {
        this.totalAmount = totalAmount;
    }

    public Double getLoan() {
        return loan;
    }

    public void setLoan( Double loan ) {
        this.loan = loan;
    }
}

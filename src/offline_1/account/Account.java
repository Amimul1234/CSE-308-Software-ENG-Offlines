package offline_1.account;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Account {

    private Double loan;
    private String userName;
    private Double depositAmount;
    private Integer accountAge;
    private AccountType accountType;

    public Account setLoan( Double loan ) {
        this.loan = loan;
        return this;
    }

    public Account setUserName( String userName ) {
        this.userName = userName;
        return this;
    }

    public Account setAccountAge( Integer accountAge ) {
        this.accountAge = accountAge;
        return this;
    }

    public Account setAccountType( AccountType accountType ) {
        this.accountType = accountType;
        return this;
    }

    public Double getLoan() {
        return loan;
    }

    public String getUserName() {
        return userName;
    }

    public Double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount( Double depositAmount ) {
        this.depositAmount = depositAmount;
    }

    public Integer getAccountAge() {
        return accountAge;
    }

    public AccountType getAccountType() {
        return accountType;
    }
}

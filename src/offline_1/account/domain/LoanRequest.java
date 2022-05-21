package offline_1.account.domain;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LoanRequest {

    private Account account;
    private Double loanAmount;
    private int loanAge;
    private boolean isLoanApproved;

    public LoanRequest( Account account, Double loanAmount, boolean isLoanApproved ) {
        this.account = account;
        this.loanAmount = loanAmount;
        this.isLoanApproved = isLoanApproved;
        loanAge = 0;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount( Account account ) {
        this.account = account;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount( Double loanAmount ) {
        this.loanAmount = loanAmount;
    }

    public boolean isLoanApproved() {
        return isLoanApproved;
    }

    public void setLoanApproved( boolean loanApproved ) {
        isLoanApproved = loanApproved;
    }

    public int getLoanAge() {
        return loanAge;
    }

    public void setLoanAge( int loanAge ) {
        this.loanAge = loanAge;
    }
}

package offline_1;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class InterestRate {

    private double studentAccountInterestRate = 0.05;
    private double savingsAccountInterestRate = 0.10;
    private double fixedDepositInterestRate = 0.15;

    public double getStudentAccountInterestRate() {
        return studentAccountInterestRate;
    }

    public void setStudentAccountInterestRate( double studentAccountInterestRate ) {
        this.studentAccountInterestRate = studentAccountInterestRate;
    }

    public double getSavingsAccountInterestRate() {
        return savingsAccountInterestRate;
    }

    public void setSavingsAccountInterestRate( double savingsAccountInterestRate ) {
        this.savingsAccountInterestRate = savingsAccountInterestRate;
    }

    public double getFixedDepositInterestRate() {
        return fixedDepositInterestRate;
    }

    public void setFixedDepositInterestRate( double fixedDepositInterestRate ) {
        this.fixedDepositInterestRate = fixedDepositInterestRate;
    }
}

package offline_1.account.constants;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public enum AccountType {

    SAVINGS("Savings"),
    STUDENT("Student"),
    LOAN("Loan"),
    FIXED_DEPOSIT("Fixed DepositService");

    private final String accountType;

    AccountType( String savings ) {
        accountType = savings;
    }

    public String getAccountType() {
        return accountType;
    }
}

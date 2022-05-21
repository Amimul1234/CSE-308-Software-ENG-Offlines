package offline_1.account.services.imp;

import offline_1.Bank;
import offline_1.account.Account;
import offline_1.account.LoanRequest;
import offline_1.account.services.LoanService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LoanServiceImp implements LoanService {

    private final Bank bank;

    public LoanServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String loanRequestApprove( Account account, Double loanAmount ) {
        switch (account.getAccountType()) {
            case SAVINGS -> {
                if (loanAmount > 10000)
                    return failLoanMessage();

                bank.addLoanRequest(new LoanRequest(account, loanAmount, false));
                return successFulLoanMessage();
            }
            case STUDENT -> {
                if (loanAmount > 1000)
                    return failLoanMessage();

                bank.addLoanRequest(new LoanRequest(account, loanAmount, false));
                return successFulLoanMessage();
            }
            case FIXED_DEPOSIT -> {
                if (loanAmount > 100000)
                    return failLoanMessage();

                bank.addLoanRequest(new LoanRequest(account, loanAmount, false));
                return successFulLoanMessage();
            }
            case LOAN -> {
                double allowableLoan = account.getLoan() * (5.0 / 100);
                if (loanAmount > allowableLoan)
                    return failLoanMessage();

                bank.addLoanRequest(new LoanRequest(account, allowableLoan, false));
                return successFulLoanMessage();
            }
            default -> {
                return "No account for current case";
            }
        }
    }

    private String failLoanMessage() {
        return "Loan request failed. Max allowable loan amount reached";
    }

    private String successFulLoanMessage() {
        return "Loan request successful, sent for approval";
    }
}

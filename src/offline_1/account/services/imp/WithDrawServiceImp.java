package offline_1.account.services.imp;

import offline_1.Bank;
import offline_1.account.domain.Account;
import offline_1.account.services.WithDrawService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class WithDrawServiceImp implements WithDrawService {

    private final Bank bank;

    public WithDrawServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String withDrawFromAccount( Account account, Double withDrawAmount ) {

        if (account.getDepositAmount() < withDrawAmount)
            return "Invalid transaction; current balance " + account.getDepositAmount() + "$";

        switch (account.getAccountType()) {
            case STUDENT -> {
                if (withDrawAmount > 10000)
                    return "Invalid transaction. Student account can not with draw more than 10,000$ in one transaction";

                bank.setTotalBankBalance(bank.getTotalBankBalance() - withDrawAmount);
                account.setDepositAmount(account.getDepositAmount() - withDrawAmount);
                return successfulWithDrawMessage(account);
            }
            case FIXED_DEPOSIT -> {
                if (account.getAccountAge() < 1)
                    return "Account must reach to maturity period of one year to withdraw";

                bank.setTotalBankBalance(bank.getTotalBankBalance() - withDrawAmount);
                account.setDepositAmount(account.getDepositAmount() - withDrawAmount);
                return successfulWithDrawMessage(account);
            }
            case SAVINGS -> {
                double currentAmountIfWithDrawn = account.getDepositAmount() - withDrawAmount;

                if (currentAmountIfWithDrawn < 1000)
                    return "Invalid transaction. Savings account must have at least 1000$ in account after withdrawal.";

                bank.setTotalBankBalance(bank.getTotalBankBalance() - withDrawAmount);
                account.setDepositAmount(account.getDepositAmount() - withDrawAmount);
                return successfulWithDrawMessage(account);
            }
            case LOAN -> {
                return "Invalid transaction. Loan account can not withdraw money";
            }
            default -> {
                return "Not a valid account type";
            }
        }
    }

    private String successfulWithDrawMessage( Account account ) {
        return "Withdraw success! Current balance is : " + account.getDepositAmount();
    }
}

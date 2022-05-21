package offline_1.account.services.imp;

import offline_1.Bank;
import offline_1.account.domain.Account;
import offline_1.account.constants.AccountType;
import offline_1.account.services.DepositService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class DepositServiceAmountImp implements DepositService {

    private final Bank bank;

    public DepositServiceAmountImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String depositToAccount( Account account, Double depositAmount ) {

        if (account.getAccountType() == AccountType.FIXED_DEPOSIT) {
            if (depositAmount < 50000)
                return "The deposit amount must not be less than 50,000$ for the Fixed DepositService account";
            else {
                bank.setTotalBankBalance(bank.getTotalBankBalance() + depositAmount);
                double currentBalance = account.getLoan() + depositAmount;
                account.setDepositAmount(currentBalance);
                return depositAmount + " deposited; current balance " + currentBalance + "$";
            }
        } else if (account.getAccountType() == AccountType.LOAN) {
            if (depositAmount > account.getLoan())
                return "Loan account can not have deposit.";
            else {
                bank.setTotalLoan(bank.getTotalLoan() - depositAmount);
                double currentBalance = account.getLoan() - depositAmount;
                account.setDepositAmount(currentBalance);
                return depositAmount + " deposited; current loan to pay " + currentBalance + "$";
            }
        } else {
            bank.setTotalBankBalance(bank.getTotalBankBalance() + depositAmount);
            double currentBalance = account.getDepositAmount() + depositAmount;
            account.setDepositAmount(currentBalance);
            return depositAmount + " deposited; current balance " + currentBalance + "$";
        }
    }
}

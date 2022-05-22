package offline_1.employee.service.imp;

import offline_1.Bank;
import offline_1.account.constants.AccountType;
import offline_1.employee.service.IncrementCurrentYearService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class IncrementCurrentYearServiceServiceImp implements IncrementCurrentYearService {

    private final Bank bank;

    public IncrementCurrentYearServiceServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String incrementCurrentYear() {
        Integer currentYear = bank.getCurrentYear();

        addInterestOnDeposit();
        deductServiceCharge();
        addLoanInterestRate();

        currentYear++;
        return currentYear + " year passed";
    }

    private void addLoanInterestRate() {

        final Double loanInterestRate = 0.10;

        bank.getAccountList()
                .forEach(account -> {
                    bank.setTotalBankBalance(loanInterestRate * account.getLoan());
                    account.setDepositAmount(account.getDepositAmount() - loanInterestRate * account.getLoan());
                });
    }

    private void deductServiceCharge() {

        final double serviceCharge = 500;

        bank.getAccountList().stream()
                .filter(account -> account.getAccountType() != AccountType.LOAN)
                .forEach(account -> {
                    if (account.getDepositAmount() > serviceCharge) {
                        bank.setTotalBankBalance(bank.getTotalBankBalance() + serviceCharge);
                        account.setDepositAmount(account.getDepositAmount() - serviceCharge);
                    }
                });

    }

    private void addInterestOnDeposit() {
        bank.getAccountList().stream()
                .filter(account -> account.getAccountType() != AccountType.LOAN)
                .forEach(account -> {
                    if (account.getAccountType() == AccountType.STUDENT) {
                        double interest = bank.getInterestRate().getStudentAccountInterestRate() * account.getDepositAmount();
                        bank.setTotalBankBalance(bank.getTotalBankBalance() - interest);
                        account.setDepositAmount(account.getDepositAmount() + interest);
                    } else if (account.getAccountType() == AccountType.SAVINGS) {
                        double interest = bank.getInterestRate().getSavingsAccountInterestRate() * account.getDepositAmount();
                        bank.setTotalBankBalance(bank.getTotalBankBalance() - interest);
                        account.setDepositAmount(account.getDepositAmount() + interest);
                    } else if (account.getAccountType() == AccountType.FIXED_DEPOSIT) {
                        double interest = bank.getInterestRate().getFixedDepositInterestRate() * account.getDepositAmount();
                        bank.setTotalBankBalance(bank.getTotalBankBalance() - interest);
                        account.setDepositAmount(account.getDepositAmount() + interest);
                    }
                });
    }
}

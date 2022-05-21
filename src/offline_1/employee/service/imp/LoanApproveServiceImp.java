package offline_1.employee.service.imp;

import offline_1.Bank;
import offline_1.account.domain.Account;
import offline_1.account.services.LoanService;
import offline_1.employee.domain.Employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LoanApproveServiceImp implements LoanService {

    private final Bank bank;

    public LoanApproveServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String loanRequestApprove( Employee employee, Account account ) {

        if (!employee.getEmployeeRoles().contains("Approve Loan"))
            return "You don’t have permission for this operation";

        return bank.getLoanRequestList().stream()
                .filter(loanRequest -> loanRequest.getAccount() == account)
                .findFirst()
                .map(loanRequest -> {

                    account.setLoan(account.getLoan() + loanRequest.getLoanAmount());
                    bank.setTotalLoan(bank.getTotalLoan() + loanRequest.getLoanAmount());

                    loanRequest.setLoanApproved(true);
                    loanRequest.setLoanAge(0);

                    return "Loan for " + account.getUserName() + " approved";
                }).orElse("No loan request found for the given account");
    }
}

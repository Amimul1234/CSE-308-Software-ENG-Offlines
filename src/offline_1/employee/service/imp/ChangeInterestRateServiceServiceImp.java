package offline_1.employee.service.imp;

import offline_1.Bank;
import offline_1.account.constants.AccountType;
import offline_1.employee.domain.Employee;
import offline_1.employee.service.ChangeInterestRateService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class ChangeInterestRateServiceServiceImp implements ChangeInterestRateService {

    private final Bank bank;

    public ChangeInterestRateServiceServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String changeInterestRateOfAccount( Employee employee, AccountType accountType, Double currentInterestRate ) {

        if (!employee.getEmployeeRoles().contains(""))
            return "You don’t have permission for this operation";

        bank.changeInterestRate(accountType, currentInterestRate / 100);

        return "Interest rate for " + accountType.getAccountType() + " changed";
    }
}

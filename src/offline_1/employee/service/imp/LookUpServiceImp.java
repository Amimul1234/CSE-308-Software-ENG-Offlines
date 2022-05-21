package offline_1.employee.service.imp;

import offline_1.Bank;
import offline_1.account.domain.Account;
import offline_1.employee.domain.Employee;
import offline_1.employee.service.LookUpService;

import java.util.Optional;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LookUpServiceImp implements LookUpService {

    private final Bank bank;

    public LookUpServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String lookUpForAccount( Employee employee, String userName ) {

        if (employee.getEmployeeRoles().contains("Lookup")) {

            Optional<Account> accounts = bank.getAccountList().stream()
                    .filter(account -> account.getUserName().equals(userName))
                    .findFirst();

            return accounts.map(account -> userName + " current balance " + account.getDepositAmount() + "$")
                    .orElse("No account exists with the given user name");
        } else {
            return "You don't have permission for this operation";
        }

    }
}

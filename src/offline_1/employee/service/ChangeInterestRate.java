package offline_1.employee.service;

import offline_1.account.domain.Account;
import offline_1.employee.domain.Employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface ChangeInterestRate {
    String changeInterestRateOfAccount( Employee employee, Account account );
}

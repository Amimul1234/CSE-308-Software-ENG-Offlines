package offline_1.employee.service;

import offline_1.account.constants.AccountType;
import offline_1.employee.domain.Employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface ChangeInterestRateService {
    String changeInterestRateOfAccount( Employee employee, AccountType accountType, Double currentInterestRate );
}

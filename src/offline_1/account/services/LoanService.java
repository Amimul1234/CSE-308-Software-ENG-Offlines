package offline_1.account.services;

import offline_1.account.Account;
import offline_1.employee.Employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface LoanService {
    String loanRequestApprove( Employee employee, Account account );
}

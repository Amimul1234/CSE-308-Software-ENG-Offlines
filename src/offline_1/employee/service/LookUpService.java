package offline_1.employee.service;

import offline_1.employee.domain.Employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface LookUpService {
    String lookUpForAccount( Employee employee, String userName );
}

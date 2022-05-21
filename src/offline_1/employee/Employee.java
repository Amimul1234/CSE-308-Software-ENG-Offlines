package offline_1.employee;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Employee {

    private final EmployeeType employeeType;
    private final List<String> employeeRoles;

    public Employee( EmployeeType employeeType ) {
        this.employeeType = employeeType;
        employeeRoles = new LinkedList<>();
    }

    public void addEmployeeRole( String role ) {
        employeeRoles.add(role);
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public List<String> getEmployeeRoles() {
        return employeeRoles;
    }
}

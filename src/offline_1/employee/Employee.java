package offline_1.employee;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Employee {

    private String employeeName;
    private final EmployeeType employeeType;
    private final List<String> employeeRoles;

    public Employee( String employeeName, EmployeeType employeeType ) {
        this.employeeName = employeeName;
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

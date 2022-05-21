package offline_1.employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class EmployeeFactory {

    public Employee createEmployee( String employeeName, EmployeeType employeeType ) {

        Employee employee = new Employee(employeeName, employeeType);

        if (employeeType == EmployeeType.MANAGING_DIRECTOR) {
            employee.addEmployeeRole("Approve Loan");
            employee.addEmployeeRole("Change Interest Rate");
            employee.addEmployeeRole("See Internal Fund");
        } else if (employeeType == EmployeeType.OFFICER) {
            employee.addEmployeeRole("Approve Loan");
        }

        employee.addEmployeeRole("Lookup");

        return employee;
    }
}

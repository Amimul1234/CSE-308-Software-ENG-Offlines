package offline_1.employee;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public enum EmployeeType {

    MANAGING_DIRECTOR("Managing Director"),
    OFFICER("Officer"),
    CASHIER("Cashier");

    private final String employeeType;

    EmployeeType( String s ) {
        employeeType = s;
    }

    public String getEmployeeType() {
        return employeeType;
    }
}

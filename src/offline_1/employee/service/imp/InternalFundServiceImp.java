package offline_1.employee.service.imp;

import offline_1.Bank;
import offline_1.employee.domain.Employee;
import offline_1.employee.service.InternalFundService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class InternalFundServiceImp implements InternalFundService {

    private final Bank bank;

    public InternalFundServiceImp() {
        bank = Bank.getInstance();
    }

    @Override
    public String seeInternalFundOfBank( Employee employee ) {

        if (!employee.getEmployeeRoles().contains("See Internal Fund"))
            return "You don’t have permission for this operation";

        return "Current fund of bank is " + (bank.getTotalBankBalance() - bank.getTotalLoan()) + "$";
    }

}

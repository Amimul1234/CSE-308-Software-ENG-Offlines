package offline_1;

import offline_1.account.constants.AccountType;
import offline_1.account.domain.LoanRequest;
import offline_1.employee.domain.Employee;
import offline_1.employee.service.ChangeInterestRateService;
import offline_1.employee.service.InternalFundService;
import offline_1.employee.service.LoanApproveService;
import offline_1.employee.service.LookUpService;
import offline_1.employee.service.imp.ChangeInterestRateServiceServiceImp;
import offline_1.employee.service.imp.InternalFundServiceImp;
import offline_1.employee.service.imp.LoanApproveServiceImp;
import offline_1.employee.service.imp.LookUpServiceImp;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CommandProcessorForEmployees {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private Employee employee;
    private final Bank bank;
    private final LookUpService lookUpService;
    private final LoanApproveService loanApproveService;
    private final InternalFundService internalFundService;
    private final ChangeInterestRateService changeInterestRateService;

    public CommandProcessorForEmployees() {
        bank = Bank.getInstance();

        lookUpService = new LookUpServiceImp();
        loanApproveService = new LoanApproveServiceImp();
        internalFundService = new InternalFundServiceImp();
        changeInterestRateService = new ChangeInterestRateServiceServiceImp();
    }

    public String openSession( Employee employee ) {

        this.employee = employee;

        if (employee.getEmployeeRoles().contains("Approve Loan")) {
            for (LoanRequest loanRequest : bank.getLoanRequestList()) {
                if (!loanRequest.isLoanApproved()) {
                    return employee.getEmployeeName() + " active, there are loan approval request";
                }
            }
        }

        return employee.getEmployeeName() + " active";
    }

    public String lookUpForAccount( String command ) {

        String[] s = command.split(" ");

        String userName = s[1];

        try {
            return lookUpService.lookUpForAccount(employee, userName);
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not lookup for account. Exception occurred";
        }
    }

    public String changeInterestRate( String command ) {

        AccountType interestRateChangeAccountType;
        String[] s = command.split(" ");

        String accountType = s[1];
        String currentInterestRate = s[2];

        if (accountType.equals(AccountType.STUDENT.getAccountType()))
            interestRateChangeAccountType = AccountType.STUDENT;
        else if (accountType.equals(AccountType.SAVINGS.getAccountType()))
            interestRateChangeAccountType = AccountType.SAVINGS;
        else if (accountType.equals(AccountType.FIXED_DEPOSIT.getAccountType()))
            interestRateChangeAccountType = AccountType.FIXED_DEPOSIT;
        else
            return "Please provide correct account type";

        try {
            return changeInterestRateService.changeInterestRateOfAccount(employee, interestRateChangeAccountType, Double.parseDouble(currentInterestRate));
        } catch (Exception exception) {
            System.out.println(ANSI_RED + "Exception is : " + exception + ANSI_RESET);
            return "Can not change interest rate. Exception occurred";
        }
    }

    public void approveLoan() {
        bank.getLoanRequestList().forEach(loanRequest -> {
            if (!loanRequest.isLoanApproved()) {
                System.out.println(loanApproveService.loanRequestApprove(employee, loanRequest.getAccount()));
            }
        });
    }

    public String seeInternalFunding() {
        return internalFundService.seeInternalFundOfBank(employee);
    }

    public String closeSession() {
        String employeeName = employee.getEmployeeName();
        employee = null;
        return "Operation for " + employeeName + " closed";
    }

    public boolean checkIfSessionActive() {
        return employee != null;
    }

    public boolean incrementCurrentYear() {
        return false;
    }
}

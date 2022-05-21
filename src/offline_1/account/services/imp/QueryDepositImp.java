package offline_1.account.services.imp;

import offline_1.account.Account;
import offline_1.account.services.QueryDeposit;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class QueryDepositImp implements QueryDeposit {

    @Override
    public String queryDepositAmount( Account account ) {
        return "Current balance, " + account.getDepositAmount() + "$, loan " + account.getLoan() + "$";
    }

}

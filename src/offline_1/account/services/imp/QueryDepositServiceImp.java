package offline_1.account.services.imp;

import offline_1.account.Account;
import offline_1.account.services.QueryDepositService;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class QueryDepositServiceImp implements QueryDepositService {

    @Override
    public String queryDepositAmount( Account account ) {
        return "Current balance, " + account.getDepositAmount() + "$, loan " + account.getLoan() + "$";
    }

}

package offline_1.account.services;

import offline_1.account.constants.AccountType;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface CreateAccountService {
    String createNewAccount( String userName, AccountType accountType, Double initialDeposit );
}

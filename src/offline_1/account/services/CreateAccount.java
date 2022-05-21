package offline_1.account.services;

import offline_1.account.AccountType;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface CreateAccount {
    String createNewAccount( String userName, AccountType accountType, Double initialDeposit );
}

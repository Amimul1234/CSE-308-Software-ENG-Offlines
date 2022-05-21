package offline_1.account.services;

import offline_1.account.Account;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface DepositService {
    String depositFromAccount( Account account, Double depositAmount );
}

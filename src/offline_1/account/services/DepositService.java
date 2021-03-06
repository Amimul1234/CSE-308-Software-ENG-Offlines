package offline_1.account.services;

import offline_1.account.domain.Account;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface DepositService {
    String depositToAccount( Account account, Double depositAmount );
}

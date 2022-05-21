package offline_1;

import offline_1.account.services.CreateAccountService;
import offline_1.account.services.imp.CreateAccountServiceImp;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CommandProcessor {

    private final CreateAccountService createAccountService;

    public CommandProcessor() {
        createAccountService = new CreateAccountServiceImp();
    }

    public String createNewAccount( String command ) {

        String[] s = command.split(" ");

        String userName = s[1];
        String accountType = s[2];
        String amount = s[3];

        createAccountService.createNewAccount()

        return null;
    }

}

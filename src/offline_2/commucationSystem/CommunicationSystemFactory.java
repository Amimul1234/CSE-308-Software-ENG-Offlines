package offline_2.commucationSystem;

import offline_1.util.Colors;
import offline_2.commucationSystem.communicationModuleImp.SimCard;
import offline_2.commucationSystem.communicationModuleImp.WifiModule;
import offline_2.commucationSystem.communicationSystemImp.MobileCommunicationSystem;
import offline_2.commucationSystem.communicationSystemImp.WifiCommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CommunicationSystemFactory {

    public Communication getCommunication( int channelNumber, String serviceName ) {

        if (serviceName.equalsIgnoreCase("WIFI_SERVICE")) {
            return new Communication()
                    .setChannelNumber(channelNumber)
                    .setCommunicationSystem(WifiCommunicationSystem.getInstance())
                    .setCommunicationModule(WifiModule.getInstance());
        } else if (serviceName.equalsIgnoreCase("MOBILE_DATA_SERVICE")) {
            return new Communication()
                    .setChannelNumber(channelNumber)
                    .setCommunicationSystem(MobileCommunicationSystem.getInstance())
                    .setCommunicationModule(SimCard.getInstance());
        } else {
            System.out.println(Colors.ANSI_RED + "Given communication service does not exists" + Colors.ANSI_RESET);
            return null;
        }
    }

}

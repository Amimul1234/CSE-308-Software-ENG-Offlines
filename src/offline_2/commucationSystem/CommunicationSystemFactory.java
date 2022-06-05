package offline_2.commucationSystem;

import offline_1.util.Colors;
import offline_2.commucationSystem.communicationSystemImp.MobileCommunicationSystem;
import offline_2.commucationSystem.communicationSystemImp.WifiCommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class CommunicationSystemFactory {

    public Communication getCommunication( int channelNumber, String serviceName ) {

        if (serviceName.equalsIgnoreCase("Wifi Service")) {
            return new Communication()
                    .setChannelNumber(channelNumber)
                    .setCommunicationSystem(WifiCommunicationSystem.getInstance());
        } else if (serviceName.equalsIgnoreCase("Mobile data service")) {
            return new Communication()
                    .setChannelNumber(channelNumber)
                    .setCommunicationSystem(MobileCommunicationSystem.getInstance());
        } else {
            System.out.println(Colors.ANSI_RED + "Given communication service does not exists" + Colors.ANSI_RESET);
            return null;
        }
    }

}

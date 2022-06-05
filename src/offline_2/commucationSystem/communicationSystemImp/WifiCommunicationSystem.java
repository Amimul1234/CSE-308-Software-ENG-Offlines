package offline_2.commucationSystem.communicationSystemImp;

import offline_2.commucationSystem.CommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class WifiCommunicationSystem implements CommunicationSystem {

    private double yearlyCommunicationCost;
    private static WifiCommunicationSystem wifiCommunicationSystem;

    private WifiCommunicationSystem() {

    }

    public static WifiCommunicationSystem getInstance() {
        if (wifiCommunicationSystem == null)
            wifiCommunicationSystem = new WifiCommunicationSystem();
        return wifiCommunicationSystem;
    }

    @Override
    public void setYearlyCommunicationCost( double yearlyCommunicationCost ) {
        this.yearlyCommunicationCost = yearlyCommunicationCost;
    }

    @Override
    public double getYearlyCommunicationCost() {
        return yearlyCommunicationCost;
    }
}

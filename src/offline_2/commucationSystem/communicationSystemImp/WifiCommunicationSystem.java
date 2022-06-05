package offline_2.commucationSystem.communicationSystemImp;

import offline_2.commucationSystem.CommunicationModule;
import offline_2.commucationSystem.CommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class WifiCommunicationSystem implements CommunicationSystem {

    private double yearlyCommunicationCost;
    private CommunicationModule communicationModule;
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

    public CommunicationModule getCommunicationModule() {
        return communicationModule;
    }

    public void setCommunicationModule( CommunicationModule communicationModule ) {
        this.communicationModule = communicationModule;
    }
}

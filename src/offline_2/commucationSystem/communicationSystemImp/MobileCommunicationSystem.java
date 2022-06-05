package offline_2.commucationSystem.communicationSystemImp;

import offline_2.commucationSystem.CommunicationModule;
import offline_2.commucationSystem.CommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class MobileCommunicationSystem implements CommunicationSystem {

    private double yearlyCommunicationCost;
    private CommunicationModule communicationModule;
    private static MobileCommunicationSystem mobileCommunicationSystem;

    private MobileCommunicationSystem() {

    }

    public static MobileCommunicationSystem getInstance() {
        if (mobileCommunicationSystem == null)
            mobileCommunicationSystem = new MobileCommunicationSystem();
        return mobileCommunicationSystem;
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

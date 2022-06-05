package offline_2.commucationSystem.communicationSystemImp;

import offline_2.commucationSystem.CommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class MobileCommunicationSystem implements CommunicationSystem {

    private double yearlyCommunicationCost;
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
}

package offline_2.displayUnit.communicationSystemImp;

import offline_2.displayUnit.CommunicationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class WifiCommunicationSystem implements CommunicationSystem {

    private double yearlyCommunicationCost;

    @Override
    public String communicateWithApplication() {
        return null;
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

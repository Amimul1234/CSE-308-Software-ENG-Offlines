package offline_2.commucationSystem.communicationModuleImp;

import offline_2.commucationSystem.CommunicationModule;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class SimCard implements CommunicationModule {

    private double modulePrice;
    private static SimCard simCard;

    private SimCard(){

    }

    public static SimCard getInstance(){
        if(simCard == null)
            simCard = new SimCard();
        return simCard;
    }

    @Override
    public void setModulePrice( double modulePrice ) {
        this.modulePrice = modulePrice;
    }

    @Override
    public double getModulePrice() {
        return modulePrice;
    }

}

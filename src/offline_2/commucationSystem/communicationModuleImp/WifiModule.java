package offline_2.commucationSystem.communicationModuleImp;

import offline_2.commucationSystem.CommunicationModule;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class WifiModule implements CommunicationModule {

    private double modulePrice;
    private static WifiModule wifiModule;

    private WifiModule() {

    }

    public static WifiModule getInstance() {
        if (wifiModule == null)
            wifiModule = new WifiModule();
        return wifiModule;
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

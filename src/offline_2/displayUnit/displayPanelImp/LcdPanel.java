package offline_2.displayUnit.displayPanelImp;

import offline_2.displayUnit.DisplaySystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LcdPanel implements DisplaySystem {

    private double panelPrice;

    @Override
    public void setDisplaySystemPrice( double displaySystemPrice ) {
        this.panelPrice = displaySystemPrice;
    }

    @Override
    public double getDisplaySystemPrice() {
        return panelPrice;
    }
}

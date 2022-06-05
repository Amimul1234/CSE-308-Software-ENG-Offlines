package offline_2.displayUnit.displayPanelImp;

import offline_2.displayUnit.DisplaySystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LedMatrix implements DisplaySystem {

    private double ledMatrixPrice;

    @Override
    public void setDisplaySystemPrice( double displaySystemPrice ) {
        this.ledMatrixPrice = displaySystemPrice;
    }

    @Override
    public double getDisplaySystemPrice() {
        return ledMatrixPrice;
    }
}

package offline_2.problem1.displayUnit.displayPanelImp;

import offline_2.problem1.displayUnit.DisplaySystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class LedMatrix implements DisplaySystem {

    private double ledMatrixPrice;
    private static LedMatrix ledMatrix;

    private LedMatrix() {

    }

    public static LedMatrix getInstance() {
        if (ledMatrix == null)
            ledMatrix = new LedMatrix();
        return ledMatrix;
    }

    @Override
    public void setDisplaySystemPrice( double displaySystemPrice ) {
        this.ledMatrixPrice = displaySystemPrice;
    }

    @Override
    public double getDisplaySystemPrice() {
        return ledMatrixPrice;
    }
}

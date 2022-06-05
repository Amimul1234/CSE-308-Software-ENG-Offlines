package offline_2;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class ControllerApplication {

    private double cost;
    private static ControllerApplication controllerApplication;

    private ControllerApplication() {

    }

    public static ControllerApplication getInstance() {
        if (controllerApplication == null)
            controllerApplication = new ControllerApplication();
        return controllerApplication;
    }

    public double getCost() {
        return cost;
    }

    public void setCost( double cost ) {
        this.cost = cost;
    }
}

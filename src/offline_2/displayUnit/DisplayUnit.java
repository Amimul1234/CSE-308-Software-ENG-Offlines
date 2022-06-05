package offline_2.displayUnit;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class DisplayUnit {

    private Processor processor;
    private DisplaySystem displaySystem;
    private double displayUnitTotalPrice;

    public Processor getProcessor() {
        return processor;
    }

    public DisplayUnit setProcessor( Processor processor ) {
        this.processor = processor;
        return this;
    }

    public DisplaySystem getDisplaySystem() {
        return displaySystem;
    }

    public DisplayUnit setDisplaySystem( DisplaySystem displaySystem ) {
        this.displaySystem = displaySystem;
        return this;
    }

    public void calculateDisplayUnitTotalPrice() {
        displayUnitTotalPrice = processor.getProcessorPrice() + displaySystem.getDisplaySystemPrice();
    }

    public double getDisplayUnitTotalPrice() {
        return displayUnitTotalPrice;
    }
}

package offline_2.displayUnit.processorImpl;

import offline_2.displayUnit.Processor;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class RaspberryPi implements Processor {

    private double processorPrice;

    @Override
    public void setProcessorPrice( double processorPrice ) {
        this.processorPrice = processorPrice;
    }

    @Override
    public double getProcessorPrice() {
        return processorPrice;
    }
}

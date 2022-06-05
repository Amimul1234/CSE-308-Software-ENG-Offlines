package offline_2.problem1.displayUnit.processorImpl;

import offline_2.problem1.displayUnit.Processor;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class RaspberryPi implements Processor {

    private double processorPrice;
    private static RaspberryPi raspberryPi;

    private RaspberryPi() {

    }

    public static RaspberryPi getInstance() {
        if (raspberryPi == null)
            raspberryPi = new RaspberryPi();
        return raspberryPi;
    }

    @Override
    public void setProcessorPrice( double processorPrice ) {
        this.processorPrice = processorPrice;
    }

    @Override
    public double getProcessorPrice() {
        return processorPrice;
    }
}

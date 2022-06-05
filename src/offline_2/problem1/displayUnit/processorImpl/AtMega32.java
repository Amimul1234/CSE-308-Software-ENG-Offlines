package offline_2.problem1.displayUnit.processorImpl;

import offline_2.problem1.displayUnit.Processor;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class AtMega32 implements Processor {

    private double processorPrice;
    private static AtMega32 atMega32;

    private AtMega32() {

    }

    public static AtMega32 getInstance() {
        if (atMega32 == null)
            atMega32 = new AtMega32();
        return atMega32;
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

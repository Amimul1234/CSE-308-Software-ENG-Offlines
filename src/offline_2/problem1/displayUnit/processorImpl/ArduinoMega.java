package offline_2.problem1.displayUnit.processorImpl;

import offline_2.problem1.displayUnit.Processor;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class ArduinoMega implements Processor {

    private double processorPrice;
    private static ArduinoMega arduinoMega;

    private ArduinoMega() {

    }

    public static ArduinoMega getInstance() {
        if (arduinoMega == null)
            arduinoMega = new ArduinoMega();
        return arduinoMega;
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

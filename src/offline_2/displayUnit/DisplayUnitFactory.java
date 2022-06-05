package offline_2.displayUnit;

import offline_1.util.Colors;
import offline_2.displayUnit.displayPanelImp.LcdPanel;
import offline_2.displayUnit.displayPanelImp.LedMatrix;
import offline_2.displayUnit.processorImpl.ArduinoMega;
import offline_2.displayUnit.processorImpl.AtMega32;
import offline_2.displayUnit.processorImpl.RaspberryPi;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class DisplayUnitFactory {

    private DisplayUnit displayUnit;

    public DisplayUnit getDisplayUnit( String queueManagementSystemName ) {
        if (queueManagementSystemName.equalsIgnoreCase("Deluxe")) {
            return displayUnit = new DisplayUnit()
                    .setDisplaySystem(new LcdPanel())
                    .setProcessor(new RaspberryPi());
        } else if (queueManagementSystemName.equalsIgnoreCase("Optimal")) {
            return displayUnit = new DisplayUnit()
                    .setProcessor(new ArduinoMega())
                    .setDisplaySystem(new LedMatrix());
        } else if (queueManagementSystemName.equalsIgnoreCase("Poor")) {
            return displayUnit = new DisplayUnit()
                    .setProcessor(new AtMega32())
                    .setDisplaySystem(new LedMatrix());
        } else {
            System.out.println(Colors.ANSI_RED + "No valid name for the queue management system" + Colors.ANSI_RESET);
            return null;
        }
    }
}
package offline_2.problem1.displayUnit;

import offline_2.problem1.util.Colors;
import offline_2.problem1.displayUnit.displayPanelImp.LcdPanel;
import offline_2.problem1.displayUnit.displayPanelImp.LedMatrix;
import offline_2.problem1.displayUnit.processorImpl.ArduinoMega;
import offline_2.problem1.displayUnit.processorImpl.AtMega32;
import offline_2.problem1.displayUnit.processorImpl.RaspberryPi;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class DisplayUnitFactory {

    private DisplayUnit displayUnit;

    public DisplayUnit getDisplayUnit( String queueManagementSystemName ) {
        if (queueManagementSystemName.equalsIgnoreCase("Deluxe")) {
            return displayUnit = new DisplayUnit()
                    .setDisplaySystem(LcdPanel.getInstance())
                    .setProcessor(RaspberryPi.getInstance());
        } else if (queueManagementSystemName.equalsIgnoreCase("Optimal")) {
            return displayUnit = new DisplayUnit()
                    .setProcessor(ArduinoMega.getInstance())
                    .setDisplaySystem(LedMatrix.getInstance());
        } else if (queueManagementSystemName.equalsIgnoreCase("Poor")) {
            return displayUnit = new DisplayUnit()
                    .setProcessor(AtMega32.getInstance())
                    .setDisplaySystem(LedMatrix.getInstance());
        } else {
            System.out.println(Colors.ANSI_RED + "No valid name for the queue management system" + Colors.ANSI_RESET);
            return null;
        }
    }
}

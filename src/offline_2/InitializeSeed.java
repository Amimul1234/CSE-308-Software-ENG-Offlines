package offline_2;

import offline_2.commucationSystem.communicationModuleImp.SimCard;
import offline_2.commucationSystem.communicationModuleImp.WifiModule;
import offline_2.commucationSystem.communicationSystemImp.MobileCommunicationSystem;
import offline_2.commucationSystem.communicationSystemImp.WifiCommunicationSystem;
import offline_2.displayUnit.displayPanelImp.LcdPanel;
import offline_2.displayUnit.displayPanelImp.LedMatrix;
import offline_2.displayUnit.processorImpl.ArduinoMega;
import offline_2.displayUnit.processorImpl.AtMega32;
import offline_2.displayUnit.processorImpl.RaspberryPi;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class InitializeSeed {

    private static InitializeSeed initializeSeed;

    private InitializeSeed() {

    }

    public static InitializeSeed getInstance() {
        if (initializeSeed == null)
            initializeSeed = new InitializeSeed();
        return initializeSeed;
    }

    public void initializeSeeds( Scanner scanner ) {
        initializeProcessorPrices(scanner);
        initializeDisplayPanelPrices(scanner);
        initializeCommunicationModulePrices(scanner);
        initializeCommunicationYearlyCost(scanner);
        initializeControllerApplicationCost(scanner);
    }

    private static void initializeControllerApplicationCost( Scanner scanner ) {
        System.out.print("Please enter controller application cost:- ");
        ControllerApplication.getInstance().setCost(scanner.nextDouble());
    }

    private static void initializeCommunicationYearlyCost( Scanner scanner ) {
        System.out.print("Please enter Mobile yearly communication cost:- ");
        MobileCommunicationSystem.getInstance().setYearlyCommunicationCost(scanner.nextDouble());

        System.out.print("Please enter Wifi yearly communication cost:- ");
        WifiCommunicationSystem.getInstance().setYearlyCommunicationCost(scanner.nextDouble());
    }

    private static void initializeCommunicationModulePrices( Scanner scanner ) {
        System.out.print("Please enter Sim card price:- ");
        SimCard.getInstance().setModulePrice(scanner.nextDouble());

        System.out.print("Please enter Wifi module price:- ");
        WifiModule.getInstance().setModulePrice(scanner.nextDouble());
    }

    private static void initializeDisplayPanelPrices( Scanner scanner ) {
        System.out.print("Please enter LCD panel price:- ");
        LcdPanel.getInstance().setDisplaySystemPrice(scanner.nextDouble());

        System.out.print("Please enter LED matrix price:- ");
        LedMatrix.getInstance().setDisplaySystemPrice(scanner.nextDouble());
    }

    private static void initializeProcessorPrices( Scanner scanner ) {
        System.out.print("Please enter Arduino Mega price:- ");
        ArduinoMega.getInstance().setProcessorPrice(scanner.nextDouble());

        System.out.print("Please enter AtMega32 price:- ");
        AtMega32.getInstance().setProcessorPrice(scanner.nextDouble());

        System.out.print("Please enter Raspberry PI price:- ");
        RaspberryPi.getInstance().setProcessorPrice(scanner.nextDouble());
    }
}

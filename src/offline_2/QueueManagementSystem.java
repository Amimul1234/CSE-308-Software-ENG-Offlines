package offline_2;

import offline_2.commucationSystem.Communication;
import offline_2.commucationSystem.communicationModuleImp.SimCard;
import offline_2.commucationSystem.communicationModuleImp.WifiModule;
import offline_2.commucationSystem.communicationSystemImp.MobileCommunicationSystem;
import offline_2.commucationSystem.communicationSystemImp.WifiCommunicationSystem;
import offline_2.displayUnit.DisplayUnit;
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

public class QueueManagementSystem {

    private ControllerApplication controllerApplication;
    private Communication communication;
    private DisplayUnit displayUnit;

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);

        initializePrices(scanner);

        System.out.println("Please enter queue management system name:- ");

    }

    private static void initializePrices( Scanner scanner ) {
        initializeProcessorPrices(scanner);
        initializeDisplayPanelPrices(scanner);
        initializeCommunicationModulePrices(scanner);
        initializeCommunicationYearlyCost(scanner);
    }

    private static void initializeCommunicationYearlyCost( Scanner scanner ) {
        System.out.println("Please enter Mobile yearly communication cost:- ");
        MobileCommunicationSystem.getInstance().setYearlyCommunicationCost(scanner.nextDouble());

        System.out.println("Please enter Wifi yearly communication cost:- ");
        WifiCommunicationSystem.getInstance().setYearlyCommunicationCost(scanner.nextDouble());
    }

    private static void initializeCommunicationModulePrices( Scanner scanner ) {
        System.out.println("Please enter Sim card price:- ");
        SimCard.getInstance().setModulePrice(scanner.nextDouble());

        System.out.println("Please enter Wifi module price:- ");
        WifiModule.getInstance().setModulePrice(scanner.nextDouble());
    }

    private static void initializeDisplayPanelPrices( Scanner scanner ) {
        System.out.println("Please enter LCD panel price:- ");
        LcdPanel.getInstance().setDisplaySystemPrice(scanner.nextDouble());

        System.out.println("Please enter LED matrix price:- ");
        LedMatrix.getInstance().setDisplaySystemPrice(scanner.nextDouble());
    }

    private static void initializeProcessorPrices( Scanner scanner ) {
        System.out.println("Please enter Arduino Mega price:- ");
        ArduinoMega.getInstance().setProcessorPrice(scanner.nextDouble());

        System.out.println("Please enter AtMega32 price:- ");
        AtMega32.getInstance().setProcessorPrice(scanner.nextDouble());

        System.out.println("Please enter Raspberry PI price:- ");
        RaspberryPi.getInstance().setProcessorPrice(scanner.nextDouble());
    }
}

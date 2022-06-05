package offline_2.problem1;

import offline_2.problem1.commucationSystem.Communication;
import offline_2.problem1.commucationSystem.CommunicationSystemFactory;
import offline_2.problem1.displayUnit.DisplayUnit;
import offline_2.problem1.displayUnit.DisplayUnitFactory;

import java.util.Scanner;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class QueueManagementSystem {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        InitializeSeed.getInstance().initializeSeeds(scanner);

        System.out.println();
        System.out.println();

        while (!scanner.nextLine().equalsIgnoreCase("exit")) {
            makeQueueManagementSystem(scanner);
        }
    }

    private static void makeQueueManagementSystem( Scanner scanner ) {

        System.out.print("Please enter queue management system name:- ");
        DisplayUnit displayUnit = new DisplayUnitFactory().getDisplayUnit(scanner.nextLine());

        System.out.print("Please enter channel number and service name:- ");

        int channelNumber = scanner.nextInt();
        scanner.nextLine();
        scanner.nextLine();
        String serviceName = scanner.nextLine();

        Communication communication = new CommunicationSystemFactory().getCommunication(channelNumber, serviceName);

        System.out.print("Please enter total unit number:- ");
        int totalUnit = scanner.nextInt();

        double totalCost = displayUnit.getDisplayUnitTotalPrice() + ControllerApplication.getInstance().getCost()
                + communication.getCommunicationSystem().getYearlyCommunicationCost() + communication.getCommunicationModule().getModulePrice();

        System.out.println("Total cost is : " + totalCost * totalUnit);
        System.out.println();
        System.out.println();
    }
}

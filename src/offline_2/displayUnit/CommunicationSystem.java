package offline_2.displayUnit;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public interface CommunicationSystem {
    String communicateWithApplication();

    void setYearlyCommunicationCost( double yearlyCommunicationCost );

    double getYearlyCommunicationCost();
}

package offline_2.commucationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Communication {

    private int channelNumber;
    private double totalCommunicationCost;
    private CommunicationSystem communicationSystem;

    public int getChannelNumber() {
        return channelNumber;
    }

    public Communication setChannelNumber( int channelNumber ) {
        this.channelNumber = channelNumber;
        return this;
    }

    public double getTotalCommunicationCost() {
        return totalCommunicationCost;
    }

    public Communication setTotalCommunicationCost( double totalCommunicationCost ) {
        this.totalCommunicationCost = totalCommunicationCost;
        return this;
    }

    public CommunicationSystem getCommunicationSystem() {
        return communicationSystem;
    }

    public Communication setCommunicationSystem( CommunicationSystem communicationSystem ) {
        this.communicationSystem = communicationSystem;
        return this;
    }

}

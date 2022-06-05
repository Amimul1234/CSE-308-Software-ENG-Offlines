package offline_2.problem1.commucationSystem;

/**
 * @author Amimul Ehsan
 * @project CSE-308-offlines
 */

public class Communication {

    private int channelNumber;
    private CommunicationSystem communicationSystem;
    private CommunicationModule communicationModule;

    public int getChannelNumber() {
        return channelNumber;
    }

    public Communication setChannelNumber( int channelNumber ) {
        this.channelNumber = channelNumber;
        return this;
    }

    public CommunicationSystem getCommunicationSystem() {
        return communicationSystem;
    }

    public Communication setCommunicationSystem( CommunicationSystem communicationSystem ) {
        this.communicationSystem = communicationSystem;
        return this;
    }

    public CommunicationModule getCommunicationModule() {
        return communicationModule;
    }

    public Communication setCommunicationModule( CommunicationModule communicationModule ) {
        this.communicationModule = communicationModule;
        return this;
    }
}

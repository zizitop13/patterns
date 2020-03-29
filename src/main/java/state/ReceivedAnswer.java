package state;

public class ReceivedAnswer implements MessageState {


    public void sendMessage(MessageStateContext stateContext) {
        throw new UnsupportedOperationException("Received is terminal state. Cause state: " + stateContext.getState());
    }

    public void receiveAnswer(MessageStateContext stateContext) {
        throw new UnsupportedOperationException("Received is terminal state. Cause state: " + stateContext.getState());
    }

    public void error(MessageStateContext stateContext) {
        stateContext.setState(new ErrorState());
    }
}

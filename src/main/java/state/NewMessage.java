package state;

public class NewMessage implements MessageState {


    public void sendMessage(MessageStateContext stateContext) {
        stateContext.setState(new SentMessage());
    }

    public void receiveAnswer(MessageStateContext stateContext) {
        stateContext.setState(new ReceivedAnswer());
    }

    public void error(MessageStateContext stateContext) {
        stateContext.setState(new ErrorState());
    }
}

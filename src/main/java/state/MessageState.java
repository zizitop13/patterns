package state;

public interface MessageState {

     void sendMessage(MessageStateContext stateContext);
     void receiveAnswer(MessageStateContext stateContext);
     void error(MessageStateContext stateContext);


}

package state;

public class MessageStateContext {

    private MessageState state;

    public MessageStateContext(MessageState state){
        this.state = state;
    }

    public void sendMessage(){
        this.state.sendMessage(this);
    }

    public void receiveAnswer(){
        this.state.receiveAnswer(this);
    }

    public void error(){
        this.state.error(this);
    }


    public MessageState getState() {
        return state;
    }

    public void setState(MessageState state) {
        this.state = state;
    }
}

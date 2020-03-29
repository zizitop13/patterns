package state;

import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MessageStateContextTest {

    private MessageStateContext stateContext;

    @Before
    public void setUp(){
        MessageState initialState = new NewMessage();
        stateContext = new MessageStateContext(initialState);
    }

    @Test
    public void sendMessageAndError(){
        stateContext.sendMessage();
        stateContext.error();
        assertThat(stateContext.getState(), instanceOf(ErrorState.class));
    }

    @Test
    public void sendMessageAndReceivedAnswer(){
        stateContext.sendMessage();
        stateContext.receiveAnswer();
        assertThat(stateContext.getState(), instanceOf(ReceivedAnswer.class));
    }

    @Test
    public void resendMessageReceivedAndError() {
        stateContext.sendMessage();
        stateContext.sendMessage();
        stateContext.sendMessage();
        stateContext.receiveAnswer();
        stateContext.error();
        stateContext.error();
        assertThat(stateContext.getState(), instanceOf(ErrorState.class));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void receiveReceivedAnswer() {
        stateContext.receiveAnswer();
        stateContext.receiveAnswer();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void sendReceivedAnswer() {
        stateContext.receiveAnswer();
        stateContext.sendMessage();
    }

    @Test
    public void error() {
        stateContext.error();
        stateContext.sendMessage();
        stateContext.error();
        stateContext.receiveAnswer();
        stateContext.error();
        assertThat(stateContext.getState(), instanceOf(ErrorState.class));
    }

    @Test
    public void setState() {
        stateContext.setState(new ResentMessage());
        assertThat(stateContext.getState(), instanceOf(ResentMessage.class));
    }
}
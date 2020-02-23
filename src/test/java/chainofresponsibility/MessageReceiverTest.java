package chainofresponsibility;

import chainofresponsibility.validator.Message;
import chainofresponsibility.validator.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class MessageReceiverTest {

    MessageValidator mainValidator;

    @Before
    public void setUp() {
        mainValidator = new MessageHeaderValidator();
        Validator<Message> messageTextGeneralValidator = new MessageTextGeneralValidator(20)
                .setNext(new MessageInsultsValidator());
        mainValidator.setNext(messageTextGeneralValidator);
    }

    @Test
    public void onMessage() throws ValidationException {
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);
        Message message = new Message();
        message.setHeader(Collections.singletonMap("from", "test"));
        message.setText("Dear Mary it is Test");
        messageReceiver.onMessage(message);
    }

    @Test(expected = ValidationException.class)
    public void onMessageFromNoOne() throws ValidationException {
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);
        Message message = new Message();
        message.setText("Dear Mary it is");
        messageReceiver.onMessage(message);
    }

    @Test(expected = ValidationException.class)
    public void onMessageToGoat() throws ValidationException {
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);
        Message message = new Message();
        message.setHeader(Collections.singletonMap("from", "test"));
        message.setText("Dear goat it is Test");
        messageReceiver.onMessage(message);
    }

    @Test(expected = ValidationException.class)
    public void onMessageWhichIsTooBig() throws ValidationException {
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);
        Message message = new Message();
        message.setHeader(Collections.singletonMap("from", "test"));
        message.setText("Dear Mary this text is too big! How are you?");
        messageReceiver.onMessage(message);
    }

    @Test(expected = ValidationException.class)
    public void onMessageWhichIsEmpty() throws ValidationException {
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);
        Message message = new Message();
        message.setHeader(Collections.singletonMap("from", "test"));
        messageReceiver.onMessage(message);
    }


}
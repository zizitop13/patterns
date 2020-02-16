package chainofresponsibility;

import chainofresponsibility.validator.ValidationException;
import chainofresponsibility.validator.Validator;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class MessageReceiverTest {

    @Test(expected = ValidationException.class)
    public void onMessage() throws ValidationException {
        MessageValidator mainValidator = new MessageHeaderValidator();
        mainValidator.setNext(new MessageTextGeneralValidator().setNext(new MessageInsultsValidator()));
        MessageReceiver messageReceiver = new MessageReceiver(mainValidator);

        Message message = new Message();
        message.setHeader(Collections.singletonMap("from", "test"));
        message.setText("Dear goat it is test");
        messageReceiver.onMessage(message);
    }
}
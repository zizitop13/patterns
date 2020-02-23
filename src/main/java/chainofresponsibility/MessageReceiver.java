package chainofresponsibility;

import chainofresponsibility.validator.Message;
import chainofresponsibility.validator.MessageValidator;
import chainofresponsibility.validator.ValidationException;


/**
 * Example client of chain of responsibility
 */
public class MessageReceiver {

    private MessageValidator messageValidator;

    public MessageReceiver(MessageValidator messageValidator) {
        this.messageValidator = messageValidator;
    }

    public void onMessage(Message message) throws ValidationException {
        messageValidator.validate(message);
        // do something
    }

}

package chainofresponsibility;

import chainofresponsibility.validator.ValidationException;

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

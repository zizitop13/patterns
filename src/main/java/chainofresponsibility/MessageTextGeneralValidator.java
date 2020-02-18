package chainofresponsibility;

import chainofresponsibility.validator.ValidationException;

public class MessageTextGeneralValidator extends MessageValidator {

    @Override
    public void validateMessage(Message request) throws ValidationException {
        if(request.getText() == null || request.getText().trim().isEmpty()){
            throw new ValidationException("Message is empty!");
        }
        if(request.getText().trim().length() > 1000){
            throw new ValidationException("Message length over 1000!");
        }
    }
}

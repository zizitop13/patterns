package chainofresponsibility;

import chainofresponsibility.validator.ValidationException;

public class MessageTextGeneralValidator extends MessageValidator {

    private int textMaxSize;

    public MessageTextGeneralValidator(int textMaxSize) {
        this.textMaxSize = textMaxSize;
    }

    @Override
    public void validateMessage(Message request) throws ValidationException {
        if(request.getText() == null || request.getText().trim().isEmpty()){
            throw new ValidationException("Message is empty!");
        }
        if(request.getText().trim().length() > textMaxSize){
            throw new ValidationException("Message length over " + textMaxSize);
        }
    }


}

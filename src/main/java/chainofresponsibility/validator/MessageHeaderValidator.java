package chainofresponsibility.validator;

import java.util.Map;

public class MessageHeaderValidator extends MessageValidator {
    @Override
    public void validateMessage(Message request) throws ValidationException {
        Map<String, String> header = request.getHeader();
        String from = header.get("from");
        if(from == null || from.trim().isEmpty()){
            throw new ValidationException("Required header property 'from' is empty!");
        }
    }
}

package chainofresponsibility;

import chainofresponsibility.validator.ValidationException;

import java.util.Arrays;
import java.util.Optional;

public class MessageInsultsValidator extends MessageValidator {

    private static final String[] insults = new String[]{"goat", "bastard", "asshole", "piece of shit"};

    public void validateMessage(Message request) throws ValidationException {
        final String text = request.getText();
        Optional<String> insultMessage = Arrays.stream(insults).parallel().filter(text::contains).findFirst();
        if(insultMessage.isPresent()){
            throw new ValidationException("Insult presented at message: " + text);
        }
    }
}

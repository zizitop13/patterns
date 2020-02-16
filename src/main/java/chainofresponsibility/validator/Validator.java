package chainofresponsibility.validator;

import chainofresponsibility.Message;

public interface Validator<T> {

    void validate(T request) throws ValidationException;
    Validator<Message> setNext(Validator<T> validator);

}

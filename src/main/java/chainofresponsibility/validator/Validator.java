package chainofresponsibility.validator;

public interface Validator<T> {
    void validate(T request) throws ValidationException;
}

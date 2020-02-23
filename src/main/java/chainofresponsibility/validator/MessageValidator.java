package chainofresponsibility.validator;

public abstract class MessageValidator implements Validator<Message> {

    protected Validator<Message> next;

    public Validator<Message> setNext(Validator<Message> next) {
        this.next = next;
        return this;
    }

    @Override
    public void validate(Message request) throws ValidationException {
        System.out.println("Validator: " + this.getClass().getName());
        this.validateMessage(request);
        if(next!=null){
            next.validate(request);
        }
    }

    protected abstract void validateMessage(Message request) throws ValidationException;
}

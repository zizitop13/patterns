package observer.publisher;

public interface EventListener<Subject> {
    void update(Subject subject);
}

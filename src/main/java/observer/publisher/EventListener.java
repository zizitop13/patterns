package observer.publisher;

/**
 *
 * function interface for observers
 * @param <Subject>
 */
public interface EventListener<Subject> {
    void update(Subject subject);
}

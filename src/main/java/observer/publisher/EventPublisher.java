package observer.publisher;

import javafx.util.Pair;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * subject
 * @param <Event> - any class or maybe better use Enum for defined event
 * @param <Payload> - any class for update when event happens
 */
public class EventPublisher<Event, Payload> {

    private Map<Pair<Event, EventListener<Payload>>, EventListener<Payload>> listeners = new LinkedHashMap<>();

    /**
     * add subscriber for event
     * @param event
     * @param listener
     */
    public void subscribe(Event event, EventListener<Payload> listener){
        listeners.put(new Pair<>(event, listener), listener);
    }

    /**
     * remove subscriber for event
     * @param event
     * @param listener
     */
    public void unsubscribe(Event event, EventListener<?> listener){
        Pair<Event, ? extends EventListener<?>> eventEventListenerPair = new Pair<>(event, listener);
        listeners.remove(eventEventListenerPair);
    }

    /**
     * notify all subscribers for some event
     * @param event
     * @param payload
     */
    public void notify(Event event, Payload payload){
        listeners.entrySet()
                .stream()
                .filter(entry -> entry.getKey().getKey().equals(event))
                .forEach(entry -> entry.getValue().update(payload));
    }
}

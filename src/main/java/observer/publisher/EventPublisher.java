package observer.publisher;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventPublisher<Event, Subject> {

    private Map<Event, EventListener<Subject>> listeners = new LinkedHashMap<>();

    public void subscribe(Event event, EventListener<Subject> listener){
        listeners.put(event, listener);
    }
    public void unsubscribe(Event event, EventListener<?> listener){
        listeners.remove(event);
    }
    public void notify(Event event, Subject subject){
        listeners.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(event))
                .forEach(entry -> entry.getValue().update(subject));
    }
}

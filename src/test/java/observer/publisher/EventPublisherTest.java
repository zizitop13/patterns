package observer.publisher;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class EventPublisherTest {

    private EventPublisher<String, String> eventPublisher;
    private List<String> notifications;

    @Before
    public void setUp() throws Exception {
        eventPublisher = new EventPublisher<>();
        notifications = new ArrayList<>();
    }

    @Test
    public void notifyWithoutSubscribers() {
        eventPublisher.notify("test", "test subject");
        //nothing happen
        assertTrue(notifications.isEmpty());
    }

    @Test
    public void notifyWithTwoSubscribersForOneEvent() {
        eventPublisher.subscribe("test", notifications::add);
        eventPublisher.subscribe("test", s -> notifications.add(s + " send to email"));
        eventPublisher.notify("test", "notify");
        assertArrayEquals(notifications.toArray(), Arrays.asList("notify", "notify send to email").toArray());
    }

    @Test
    public void notifyWithTwoSubscribersForEvent() {
        eventPublisher.subscribe("test1", notifications::add);
        eventPublisher.subscribe("test2", s -> notifications.add(s + " send to email"));
        eventPublisher.notify("test1", "notify");
        assertArrayEquals(notifications.toArray(), Collections.singletonList("notify").toArray());
    }

    @Test
    public void notifyWithTwoSubscribersWhenOneUnsubscribed() {
        EventListener<String> eventEmailListener = s -> notifications.add(s + " send to email");
        eventPublisher.subscribe("test", notifications::add);
        eventPublisher.subscribe("test", eventEmailListener);
        eventPublisher.unsubscribe("test", eventEmailListener);
        eventPublisher.notify("test", "notify");
        assertArrayEquals(notifications.toArray(), Collections.singletonList("notify").toArray());
    }

}
package alejandro.dev.events.client.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ClientEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public ClientEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(String message) {
        var clientEvent = new ClientEvent(this, message);
        applicationEventPublisher.publishEvent(clientEvent);
    }

}

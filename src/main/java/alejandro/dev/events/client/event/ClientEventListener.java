package alejandro.dev.events.client.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ClientEventListener implements ApplicationListener<ClientEvent> {

    private static final Logger log = LoggerFactory.getLogger(ClientEventListener.class);

    @Override
    public void onApplicationEvent(ClientEvent event) {
        log.info("Client event: {}", event.getMessage());
    }
}

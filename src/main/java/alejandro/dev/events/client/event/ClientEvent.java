package alejandro.dev.events.client.event;


import org.springframework.context.ApplicationEvent;

public class ClientEvent extends ApplicationEvent {

    private final String message;

    public ClientEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

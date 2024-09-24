package alejandro.dev.events.client.http;

import java.io.Serializable;
import java.util.UUID;

public record ClientResponse(UUID id, String client) implements Serializable {
    public static ClientResponse create(UUID id, String fullName, String phone) {
        return new ClientResponse(id, fullName + ", " + phone);
    }
}

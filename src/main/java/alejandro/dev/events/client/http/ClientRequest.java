package alejandro.dev.events.client.http;

import java.io.Serializable;

public record ClientRequest(String fullName, String phone) implements Serializable {
}

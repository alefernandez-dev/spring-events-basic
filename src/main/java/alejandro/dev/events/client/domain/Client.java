package alejandro.dev.events.client.domain;

import java.util.UUID;

public record Client(
        UUID id,
        String fullName,
        String phone) {
    public static Client createNew(String fullName, String phone) {
        return new Client(UUID.nameUUIDFromBytes(fullName.getBytes()), fullName, phone);
    }
}

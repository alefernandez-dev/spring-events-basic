package alejandro.dev.events.client.domain;

import java.util.List;
import java.util.UUID;

public interface ClientRepository {
    void save(Client client);
    boolean delete(UUID clientId);
    List<Client> list();
    Client findById(UUID clientId);
}

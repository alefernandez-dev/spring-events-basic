package alejandro.dev.events.client.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClientHashMapRepository implements ClientRepository{

    private final Map<UUID, Client> clients = new HashMap<>();

    @Override
    public void save(Client client) {
        clients.put(client.id(), client);
    }

    @Override
    public boolean delete(UUID clientId) {
        return clients.remove(clientId) != null;
    }

    @Override
    public List<Client> list() {
        return new ArrayList<>(clients.values());
    }

    @Override
    public Client findById(UUID clientId) {
        return clients.get(clientId);
    }
}

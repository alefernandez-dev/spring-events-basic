package alejandro.dev.events.client.service;

import alejandro.dev.events.client.domain.Client;
import alejandro.dev.events.client.domain.ClientRepository;
import alejandro.dev.events.client.event.ClientEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllClientsService {

    private final ClientRepository repository;
    private final ClientEventPublisher publisher;

    public ListAllClientsService(ClientRepository repository, ClientEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public List<Client> listAll() {
        publishEvent();
        return repository.list();
    }

    private void publishEvent() {
        publisher.publish("[Service called: ListAllClientsService - Method: listAll]");
    }

}

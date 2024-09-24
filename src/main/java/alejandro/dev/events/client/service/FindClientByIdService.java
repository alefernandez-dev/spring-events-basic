package alejandro.dev.events.client.service;

import alejandro.dev.events.client.domain.Client;
import alejandro.dev.events.client.domain.ClientRepository;
import alejandro.dev.events.client.event.ClientEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FindClientByIdService {

    private final ClientRepository repository;
    private final ClientEventPublisher publisher;

    public FindClientByIdService(ClientRepository repository, ClientEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public Client findById(UUID id) {
        publishEvent();
        return repository.findById(id);
    }

    private void publishEvent() {
        publisher.publish("[Service called: FindClientByIdService - Method: findById]");
    }

}

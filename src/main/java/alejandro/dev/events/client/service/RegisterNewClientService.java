package alejandro.dev.events.client.service;

import alejandro.dev.events.client.domain.Client;
import alejandro.dev.events.client.domain.ClientRepository;
import alejandro.dev.events.client.event.ClientEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewClientService {

    private final ClientRepository repository;
    private final ClientEventPublisher publisher;

    public RegisterNewClientService(ClientRepository repository, ClientEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public void register(Client client) {
        repository.save(client);
        publishEvent();
    }

    private void publishEvent() {
        publisher.publish("[Service called: RegisterNewClientService - Method: register]");
    }
}

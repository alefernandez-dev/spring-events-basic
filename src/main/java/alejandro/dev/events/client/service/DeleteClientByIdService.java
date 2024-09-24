package alejandro.dev.events.client.service;

import alejandro.dev.events.client.domain.ClientRepository;
import alejandro.dev.events.client.event.ClientEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteClientByIdService {

    private final ClientRepository repository;
    private final ClientEventPublisher publisher;

    public DeleteClientByIdService(ClientRepository repository, ClientEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public boolean delete(UUID id) {
        publishEvent();
        return repository.delete(id);
    }

    private void publishEvent() {
        publisher.publish("[Service called: DeleteClientByIdService - Method: delete]");
    }

}

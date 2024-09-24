package alejandro.dev.events.client.http;

import alejandro.dev.events.client.domain.Client;
import alejandro.dev.events.client.domain.ClientRepository;
import alejandro.dev.events.client.service.DeleteClientByIdService;
import alejandro.dev.events.client.service.FindClientByIdService;
import alejandro.dev.events.client.service.ListAllClientsService;
import alejandro.dev.events.client.service.RegisterNewClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final RegisterNewClientService registerNewClientService;
    private final ListAllClientsService listAllClientsService;
    private final FindClientByIdService findClientByIdService;
    private final DeleteClientByIdService deleteClientByIdService;

    public ClientController(RegisterNewClientService registerNewClientService,
                            ListAllClientsService listAllClientsService,
                            FindClientByIdService findClientByIdService,
                            DeleteClientByIdService deleteClientByIdService) {
        this.registerNewClientService = registerNewClientService;
        this.listAllClientsService = listAllClientsService;
        this.findClientByIdService = findClientByIdService;
        this.deleteClientByIdService = deleteClientByIdService;
    }

    @GetMapping
    ResponseEntity<List<ClientResponse>> listAll() {
        var response = listAllClientsService
                .listAll()
                .stream()
                .map(c -> ClientResponse.create(c.id(), c.fullName(), c.phone()))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    ResponseEntity<ClientResponse> findById(@PathVariable String id) {
        var client = findClientByIdService.findById(UUID.fromString(id));
        if(client == null) {
            return ResponseEntity.notFound().build();
        }
        var response = ClientResponse.create(client.id(), client.fullName(), client.phone());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<Message> create(@RequestBody ClientRequest clientRequest) {
        var newClient = Client.createNew(
                clientRequest.fullName(),
                clientRequest.phone()
        );
        registerNewClientService.register(newClient);
        return ResponseEntity.ok(new Message("Client created successfully"));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Message> delete(@PathVariable String id) {
        var result = deleteClientByIdService.delete(UUID.fromString(id));
        if(!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new Message("Client deleted successfully"));
    }


    record Message(String message) implements Serializable {}
}

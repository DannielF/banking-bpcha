package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.usecase.client.ClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Client", description = "Client operations")
@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping(value = "client")
@RequiredArgsConstructor
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    private final ClientUseCase useCase;

    @Operation(summary = "Get all clients")
    @Transactional(readOnly = true)
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    public List<Client> findAllClients() {
        return useCase.getAllClients();
    }

    @Operation(summary = "Get a client by id")
    @Transactional(readOnly = true)
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable Integer id) {
        logger.debug("Get by id {}", id);
        return useCase.getClientById(id);
    }

    @Operation(summary = "Create a new client")
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody Client client) {
        logger.debug("To save {}", client);
        return useCase.saveClient(client);
    }

    @Operation(summary = "Update a client")
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@RequestBody Client client) {
        logger.debug("To update {}", client);
        return useCase.updateClient(client);
    }

    @Operation(summary = "Delete a client")
    @Transactional
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void logicDeleteClient(@PathVariable Integer id) {
        logger.debug("Get by id {}", id);
        useCase.deleteClient(id);
    }
}
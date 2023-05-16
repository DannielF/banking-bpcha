package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.usecase.client.ClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Client", description = "Client operations")
@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping(name = "client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase useCase;
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Operation(summary = "Get all clients")
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    public List<Client> findAllClients() {
        return useCase.getAllClients();
    }

    @Operation(summary = "Get a client by id")
    @ApiResponse()
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return useCase.getClientById(id);
    }

    @Operation(summary = "Create a new client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody @Valid Client client) {
        return useCase.saveClient(client);
    }

    @Operation(summary = "Update a client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@RequestBody Client client) {
        return useCase.updateClient(client);
    }

    @Operation(summary = "Delete a client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @DeleteMapping(value = "/{id}")
    public Client logicDeleteClient(@PathVariable Integer id) {
        return useCase.deleteClient(id);
    }
}

package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

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
    public List<ClientDTO> findAllClients() {
        return useCase.getAllClients().stream().map(ConverterClientRest::toDTO).toList();
    }

    @Operation(summary = "Get a client by id")
    @ApiResponse()
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public ClientDTO getClientById(@PathVariable Integer id) {
        return ConverterClientRest.toDTO(useCase.getClientById(id));
    }

    @Operation(summary = "Create a new client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO saveClient(@RequestBody @Valid ClientDTO client) {
        return ConverterClientRest.toDTO(useCase.saveClient(ConverterClientRest.toEntity(client)));
    }

    @Operation(summary = "Update a client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO updateClient(@RequestBody ClientDTO client) {
        return ConverterClientRest.toDTO(useCase.updateClient(ConverterClientRest.toEntity(client)));
    }

    @Operation(summary = "Delete a client")
    @ResponseStatus(code = HttpStatus.CREATED)
    @DeleteMapping(value = "/{id}")
    public ClientDTO logicDeleteClient(@PathVariable Integer id) {
        return ConverterClientRest.toDTO(useCase.deleteClient(id));
    }
}

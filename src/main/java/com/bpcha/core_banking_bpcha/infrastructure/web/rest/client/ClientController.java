package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

import com.bpcha.core_banking_bpcha.domain.usecase.client.ClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping(name = "client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientUseCase useCase;
}

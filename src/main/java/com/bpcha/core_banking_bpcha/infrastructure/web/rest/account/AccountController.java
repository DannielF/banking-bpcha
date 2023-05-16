package com.bpcha.core_banking_bpcha.infrastructure.web.rest.account;

import com.bpcha.core_banking_bpcha.domain.usecase.account.AccountUseCase;
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
@RequestMapping(name = "account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountUseCase useCase;
}

package com.bpcha.core_banking_bpcha.infrastructure.web.rest.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.usecase.account.AccountUseCase;
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

@Tag(name = "Account", description = "Account operations")
@CrossOrigin(
        origins = {"http://localhost:4200"},
        methods = {RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}
)
@RestController
@RequestMapping(value = "account")
@RequiredArgsConstructor
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
    private final AccountUseCase useCase;

    @Operation(summary = "Get all accounts")
    @Transactional(readOnly = true)
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping()
    public List<Account> getAllAccounts() {
        return useCase.accountList();
    }

    @Operation(summary = "Get a account by id")
    @Transactional(readOnly = true)
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        logger.atInfo().log("Get by id {}", id);
        return useCase.getAccountById(id);
    }

    @Operation(summary = "Create a new account")
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Account saveAccount(@RequestBody Account account) {
        logger.atInfo().log("To save {}", account.toString());
        return useCase.createAccount(account);
    }

    @Operation(summary = "Update an account")
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Account updateAccount(@RequestBody Account account) {
        logger.atInfo().log("To update {}", account.toString());
        return useCase.updateAccount(account);
    }

    @Operation(summary = "Delete an account")
    @Transactional
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public Account deleteAccount(@PathVariable Integer id) {
        logger.atInfo().log("Delete by id {}", id);
        return useCase.deleteAccount(id);
    }
}

package com.bpcha.core_banking_bpcha.domain.usecase.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.account.gateway.AccountRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.domain.model.shared.TypeExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class AccountUseCase {
    private final AccountRepository accountRepository;

    public Account createAccount(Account accountRequest) {
        if (Objects.isNull(accountRequest)) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL_CHECK_REQUEST.toString());
        return accountRepository.createAccount(accountRequest);
    }

    public Account getAccountById(Integer id) {
        if (id == null) throw new BusinessException(TypeExceptions.ID_CANNOT_BE_NULL.toString());
        Account accountResponse = accountRepository.findAccountById(id);
        if (Objects.isNull(accountResponse)) throw new BusinessException(TypeExceptions.ENTITY_NOT_FOUND_CHECK_ID.toString());
        return accountResponse;
    }

    public List<Account> accountList() {
        return accountRepository.accountList();
    }

    public Account deleteAccount(Integer id) {
        if (id == null) throw new BusinessException(TypeExceptions.ID_CANNOT_BE_NULL.toString());
        Account accountResponse = this.getAccountById(id);
        if (Objects.isNull(accountResponse)) throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_DELETED.toString());
        return accountRepository.deleteAccount(id);
    }

    public Account updateAccount(Integer id, Account accountRequest) {
        if (Objects.isNull(accountRequest)) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL_CHECK_REQUEST.toString());
        Account accountResponse = this.getAccountById(id);
        if (Objects.isNull(accountResponse)) throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_UPDATED.toString());
        return accountRepository.updateAccount(accountRequest);
    }
}

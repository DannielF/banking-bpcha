package com.bpcha.core_banking_bpcha.domain.model.shared;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}

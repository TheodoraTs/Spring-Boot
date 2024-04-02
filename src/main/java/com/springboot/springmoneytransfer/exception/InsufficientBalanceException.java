package com.springboot.springmoneytransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException() {
        super("Insufficient balance to process money transfer.");
    }
}

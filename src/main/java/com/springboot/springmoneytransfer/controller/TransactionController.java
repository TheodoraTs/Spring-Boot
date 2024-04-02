package com.springboot.springmoneytransfer.controller;

import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;
import com.springboot.springmoneytransfer.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value ="/api/transactions", produces = "application/json",method=RequestMethod.GET)
public class TransactionController {

    @Autowired
    private  TransactionService transactionService;



    @PostMapping
    public ResponseEntity<Transaction> transferMoney(@RequestBody Account sourceAccount, Account targetAccount, BigDecimal amount, String currency) {
        Transaction  updatedEntity =  transactionService.transferMoney(sourceAccount, targetAccount, amount, currency);
        return ResponseEntity.ok(updatedEntity);
    }
}

package com.springboot.springmoneytransfer.service;

import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;
import com.springboot.springmoneytransfer.exception.AccountNotFoundException;
import com.springboot.springmoneytransfer.exception.InsufficientBalanceException;
import com.springboot.springmoneytransfer.exception.SameAccountException;
import com.springboot.springmoneytransfer.repository.AccountRepository;
import com.springboot.springmoneytransfer.repository.TransactionRepository;
import com.springboot.springmoneytransfer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private  TransactionRepository transactionRepository;
    @Autowired
    private  AccountRepository accountRepository;


    @Override
    public Transaction transferMoney(Account sourceAccount, Account targetAccount, BigDecimal amount,String currency) {

        Account sourceAccount = AccountService.getAccount(sourceAccountId);
        Account targetAccount = AccountService.getAccount(targetAccountId);

        if (sourceAccount == null || targetAccount == null) {
            throw new AccountNotFoundException();
        }

        if (sourceAccount.equals(targetAccount)) {
            throw new SameAccountException();
        }

        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        AccountService.updateAccount(sourceAccount);
        AccountService.updateAccount(targetAccount);

        Transaction transaction = new Transaction();
        transaction.setSourceAccountId(sourceAccount.getId());
        transaction.setTargetAccountId(targetAccount.getId());
        transaction.setAmount(amount);
        transaction.setCurrency(currency);


        return transactionRepository.save(transaction);
    }



}

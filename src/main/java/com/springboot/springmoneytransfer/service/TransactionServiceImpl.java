package com.springboot.springmoneytransfer.service;

import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;
import com.springboot.springmoneytransfer.exception.InsufficientBalanceException;
import com.springboot.springmoneytransfer.exception.SameAccountException;
import com.springboot.springmoneytransfer.repository.AccountRepository;
import com.springboot.springmoneytransfer.repository.TransactionRepository;
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


        Transaction transaction = new Transaction();
        transaction.setSourceAccountId(sourceAccount.getId());
        transaction.setTargetAccountId(targetAccount.getId());
        transaction.setAmount(amount);
        transaction.setCurrency(currency);


        return transactionRepository.save(transaction);
    }


    @Override
    public void validations(Account sourceAccount, Account targetAccount, BigDecimal amount,String currency) {


        if (sourceAccount.getBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }

        if (sourceAccount.equals(targetAccount)) {
            throw new SameAccountException();
        }

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccount.setBalance(targetAccount.getBalance().add(amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

}
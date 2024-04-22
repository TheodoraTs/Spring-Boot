package com.springboot.springmoneytransfer.service;

import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;
import com.springboot.springmoneytransfer.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account sourceAccount) {
        return accountRepository.save(sourceAccount);
    }
    public Account getAccount(String sourceAccountId) {
       return accountRepository.findById(sourceAccountId).orElse(null);
    }
    public Account updateAccount(Account sourceAccount) {
        return accountRepository.save(sourceAccount);
    }


//    public Account createAccount(Account targetAccount) {
//        return accountRepository.save(targetAccount);
//    }
//    public Account getAccount(String targetAccountId) {
//        return accountRepository.findById(targetAccountId).orElse(null);
//    }
//    public Account updateAccount(Account targetAccount) {
//        return accountRepository.save(targetAccount);
//    }
}

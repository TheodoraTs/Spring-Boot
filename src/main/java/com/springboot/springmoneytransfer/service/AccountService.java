package com.springboot.springmoneytransfer.service;
import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;

import java.math.BigDecimal;

public interface AccountService {


    Account createAccount(Account sourceAccount);

       Account getAccount(Account sourceAccountId);

    Account updateAccount(Account sourceAccount);
}

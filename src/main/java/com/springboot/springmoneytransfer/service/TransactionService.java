package com.springboot.springmoneytransfer.service;
import com.springboot.springmoneytransfer.entity.Account;
import com.springboot.springmoneytransfer.entity.Transaction;

import java.math.BigDecimal;

public interface TransactionService {


    Transaction transferMoney(Account sourceAccount, Account targetAccount,BigDecimal amount, String currency);

 //   void validations(Account sourceAccount, Account targetAccount, BigDecimal amount,String currency);

}

package com.sjprogramming.bankapp.service;

import com.sjprogramming.bankapp.entity.Account;

import java.util.List;

public interface AccountService {

    public Account createAccount(Account account);

    public Account getAccountDetailByAccountNumber(Long accountNumber);

    public List<Account>getAllAccountDetails();

    public Account depositAmount(Long accountnNumber,Double amount);


    public Account withdrawAmount(Long accountNumber,Double amount);

    public void closeAccount(Long accountNumber);


}

package com.sjprogramming.bankapp.service;

import com.sjprogramming.bankapp.Repository.AccountRepository;
import com.sjprogramming.bankapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements AccountService{


    @Autowired
    private AccountRepository accountRepository;



    @Override
    public Account createAccount(Account account) {
        Account account1 = accountRepository.save(account);
        return account1;
    }

    @Override
    public Account getAccountDetailByAccountNumber(Long accountNumber) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account does not exist");
        }
        Account account1 = account.get();
        return account1;
    }

    @Override
    public List<Account> getAllAccountDetails() {
        List<Account> accountList = accountRepository.findAll();
        return accountList;
    }

    @Override
    public Account depositAmount(Long accountnNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountnNumber);
           if(account.isEmpty()){
               throw new RuntimeException("Account is not present");
           }
           Account accountPresent=account.get();
       Double totalBalance= accountPresent.getAccount_balance()+amount;
           accountPresent.setAccount_balance(totalBalance);
           accountRepository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Optional<Account> account = accountRepository.findById(accountNumber);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not present");
        }
        Account accountPresent=account.get();

        double accountBalance = accountPresent.getAccount_balance() - amount;
        accountPresent.setAccount_balance(accountBalance);
        accountRepository.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {
    getAccountDetailByAccountNumber(accountNumber);
    accountRepository.deleteById(accountNumber);


    }
}

package com.sjprogramming.bankapp.Controller;

import com.sjprogramming.bankapp.entity.Account;
import com.sjprogramming.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //create the account
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);

    }

    //get account by account number
    @GetMapping("/{accountNumber}")
    public Account getAccountByAccountNumber( @PathVariable Long accountNumber){
        Account account = accountService.getAccountDetailByAccountNumber(accountNumber);
        return account;
    }

   // get All Account
    @GetMapping("/all")
    public List<Account>getAllAccountDetails(){
        List<Account> allAccountDetails = accountService.getAllAccountDetails();
        return allAccountDetails;
    }

    // deposite Amount
    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositAccount( @PathVariable Long accountNumber, @PathVariable Double amount){
        Account amount1 = accountService.depositAmount(accountNumber, amount);
        return amount1;
    }


    //WithDraw Amount
    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawAccount( @PathVariable Long accountNumber, @PathVariable Double amount){
        Account amount1 = accountService.withdrawAmount(accountNumber, amount);
        return amount1;
    }

    //delete account

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber){
        accountService.closeAccount(accountNumber);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body("Account close");
    }
}

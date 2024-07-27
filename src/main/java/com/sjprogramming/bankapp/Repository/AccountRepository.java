package com.sjprogramming.bankapp.Repository;

import com.sjprogramming.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}

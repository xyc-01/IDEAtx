package com.im.repository;

import com.im.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findAccountByPhone(String phone);
}

package com.im.service;

import com.im.core.AppBeanUtils;
import com.im.model.Account;
import com.im.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class AccountService {
    @Resource
    AccountRepository accountRepository;

    public Account getAccount(Long uid){
        Optional<Account> byId = accountRepository.findById(uid);
        return byId.get();
    }

    public Account updateAccount(Long uid,Account accountPara){
        Optional<Account> byId = accountRepository.findById(uid);

        Account account1 = byId.get();
        AppBeanUtils.copyNotNullProperties(accountPara,account1);
        return account1;
    }
}

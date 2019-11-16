package com.im.controller;


import com.im.model.Account;
import com.im.repository.AccountRepository;
import com.im.service.AccountService;
import com.im.service.AppUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mine")
public class MineController {
    @Resource
    AccountService accountService;

    @GetMapping("/{uid}")
    Object account(@PathVariable Long uid,@AuthenticationPrincipal AppUserDetailsService.AppUserDetails appUserDetails){
        System.out.println(appUserDetails);

        if (uid.equals(appUserDetails.account.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return accountService.getAccount(uid);
    }

    @PutMapping("/{uid}")
    Object updateAccount(@PathVariable Long uid,@AuthenticationPrincipal AppUserDetailsService.AppUserDetails appUserDetails,@RequestBody Account account){
        if (!uid.equals(appUserDetails.account.getId())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return accountService.updateAccount(uid.account);
    }

}

package com.example.springsecurity;

import com.example.springsecurity.account.Account;
import com.example.springsecurity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {

    @Autowired
    AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account yulseon = accountService.createAccount("yulseon", "1234");
        System.out.println(yulseon.getUsername() + " password: " + yulseon.getPassword());
    }
}

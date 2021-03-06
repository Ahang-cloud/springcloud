package com.ah.springcloud.controller;

import com.ah.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/update")
    public void update(Double money,Long userId){
        accountService.updateMoney(money,userId);
    }
}

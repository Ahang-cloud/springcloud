package com.ah.springcloud.service.impl;

import com.ah.springcloud.dao.AccountDao;
import com.ah.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;
    @Override
    public void updateMoney(Double money, Long userId) {
        accountDao.updateMoney(money,userId);
    }
}

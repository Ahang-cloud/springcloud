package com.ah.springcloud.service;

import org.apache.ibatis.annotations.Param;

public interface AccountService {
    void updateMoney(Double money,Long userId);

}

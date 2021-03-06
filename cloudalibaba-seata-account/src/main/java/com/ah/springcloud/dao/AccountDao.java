package com.ah.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
    void updateMoney(@Param("money") Double money,@Param("userId") Long userId);
}

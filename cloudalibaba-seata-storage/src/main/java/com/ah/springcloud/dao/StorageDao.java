package com.ah.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    void updateResidue(@Param("num") Integer num,@Param("userId") Long userId);
}

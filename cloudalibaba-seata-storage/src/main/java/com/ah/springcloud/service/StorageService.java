package com.ah.springcloud.service;

import org.apache.ibatis.annotations.Param;

public interface StorageService {
    void updateResidue(Integer num,Long userId);
}

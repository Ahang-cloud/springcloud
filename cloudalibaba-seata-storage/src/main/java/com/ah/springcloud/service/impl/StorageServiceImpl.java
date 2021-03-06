package com.ah.springcloud.service.impl;

import com.ah.springcloud.dao.StorageDao;
import com.ah.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void updateResidue(Integer num, Long userId) {
        storageDao.updateResidue(num,userId);
    }
}

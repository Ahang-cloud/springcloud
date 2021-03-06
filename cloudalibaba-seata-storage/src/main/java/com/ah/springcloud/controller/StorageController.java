package com.ah.springcloud.controller;

import com.ah.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/update")
    public void updateResidue(Integer num,Long userId){
        storageService.updateResidue(num, userId);
    }
}

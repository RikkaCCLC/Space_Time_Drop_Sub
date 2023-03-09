package com.george.subtrol.controller.substore;

import com.george.subtrol.pojo.Store;
import com.george.subtrol.service.substore.GetStores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStoresController {
    @Autowired
    private GetStores getStores;
    @GetMapping("/substore/getstores/")
    public List<Store> getUser(){
        return getStores.getUser();
    }
}

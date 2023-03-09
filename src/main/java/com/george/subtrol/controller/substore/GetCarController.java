package com.george.subtrol.controller.substore;

import com.george.subtrol.pojo.Store;
import com.george.subtrol.service.substore.GetCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCarController {
    @Autowired
    private GetCarService getCarService;

    @GetMapping("/substore/getcar/")
    public List<Store> getCar() {
        return getCarService.getCar();
    }
}

package com.george.subtrol.controller.substore;

import com.george.subtrol.pojo.SaleInfo;
import com.george.subtrol.service.substore.GetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetListController {
    @Autowired
    private GetListService getListService;

    @GetMapping("/substore/getlist/")
    public List<SaleInfo> getList(Integer page) {
        return getListService.getList(page);
    }
}

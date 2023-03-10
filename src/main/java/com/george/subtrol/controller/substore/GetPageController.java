package com.george.subtrol.controller.substore;

import com.alibaba.fastjson2.JSONObject;
import com.george.subtrol.service.substore.GetPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetPageController {
    @Autowired
    GetPageService getPageService;

    @GetMapping("/substore/getpage/")
    public JSONObject getPage(Integer page){
        return getPageService.getPage(page);
    }
}

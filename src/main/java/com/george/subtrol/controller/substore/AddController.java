package com.george.subtrol.controller.substore;

import com.george.subtrol.service.substore.AddService;
import com.george.subtrol.utils.RestTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddController {
    @Autowired
    private AddService addService;

    @PostMapping("/substore/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data) {
        RestTemplateUtil.restTemplate.getForObject(RestTemplateUtil.updateUrl,String.class);
        RestTemplateUtil.restTemplate.getForObject(RestTemplateUtil.upUrl,String.class);
        return addService.add(data);
    }
}

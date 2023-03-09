package com.george.subtrol.controller.substore;

import com.george.subtrol.service.substore.RemoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveController {
    @Autowired
    private RemoveService removeService;

    @PostMapping("/substore/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeService.remove(data);
    }
}

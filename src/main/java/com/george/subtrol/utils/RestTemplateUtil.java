package com.george.subtrol.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateUtil {
    public static RestTemplate restTemplate;

    public static final String updateUrl = "http://127.0.0.1:34567/centrol/update_sale_data/";
    public static final String upUrl = "http://127.0.0.1:34567/centrol/up/salenum/";
    public static final String downUrl = "http://127.0.0.1:34567/centrol/down/salenum/";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        RestTemplateUtil.restTemplate = restTemplate;
    }
}

package com.george.subtrol.service.impl.substore;

import com.alibaba.fastjson2.JSONObject;
import com.george.subtrol.service.substore.GetPageService;
import com.george.subtrol.mapper.SaleInfoMapper;
import com.george.subtrol.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class getPageServiceImpl implements GetPageService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public JSONObject getPage(Integer page) {


        return null;
    }
}

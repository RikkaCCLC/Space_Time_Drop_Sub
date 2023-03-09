package com.george.subtrol.service.impl.substore;


import com.george.subtrol.service.substore.GetStores;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStoresImpl implements GetStores {
    @Autowired
    private StoreMapper storeMapper;
    @Override
    public List<Store> getUser() {
        return storeMapper.selectList(null);
    }
}

package com.george.subtrol.service.impl.substore;

import com.george.subtrol.utils.UserDetailsImpl;
import com.george.subtrol.service.substore.RemoveService;
import com.george.subtrol.mapper.SaleInfoMapper;
import com.george.subtrol.pojo.SaleInfo;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveServiceImpl implements RemoveService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();

        int saleId = Integer.parseInt(data.get("saleId"));
        SaleInfo saleInfo = saleInfoMapper.selectById(saleId);
        Map<String, String> map = new HashMap<>();

        System.out.println("11111111111111111111111111111111");
        if (saleInfo == null) {
            map.put("error_message", "Bot不存在或已被删除");
            return map;
        }



        saleInfoMapper.deleteById(saleId);

        map.put("error_message", "success");
        return map;
    }
}

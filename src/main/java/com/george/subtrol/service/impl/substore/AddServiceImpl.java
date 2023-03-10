package com.george.subtrol.service.impl.substore;

import com.george.subtrol.utils.UserDetailsImpl;
import com.george.subtrol.service.substore.AddService;
import com.george.subtrol.mapper.SaleInfoMapper;
import com.george.subtrol.pojo.SaleInfo;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddServiceImpl implements AddService {

    @Autowired
    private SaleInfoMapper saleInfoMapper;

    @Override
    public Map<String, String> add(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();

        String stoAddr = data.get("stoAddr");
        String stoName = data.get("stoName");
        Double profit = Double.valueOf(data.get("profit"));

        Map<String, String> map = new HashMap<>();

        if (stoAddr == null || stoAddr.length() == 0) {
            map.put("error_message", "门店城市不能为空");
            return map;
        }

        if (stoName == null || stoName.length() == 0) {
            map.put("error_message", "门店地址名字不能为空");
            return map;
        }

        if (profit == null || profit == 0) {
            map.put("error_message", "订单利润不能为空");
            return map;
        }

        Date now = new Date();
        SaleInfo saleInfo = new SaleInfo(null, user.getStoid(), stoName, stoAddr,  now, profit);

        saleInfoMapper.insert(saleInfo);
        map.put("error_message", "success");

        return map;
    }
}

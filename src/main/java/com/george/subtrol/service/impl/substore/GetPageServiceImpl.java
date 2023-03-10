package com.george.subtrol.service.impl.substore;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.george.subtrol.mapper.SaleInfoMapper;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.SaleInfo;
import com.george.subtrol.pojo.Store;
import com.george.subtrol.service.substore.GetPageService;
import com.george.subtrol.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class GetPageServiceImpl implements GetPageService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public JSONObject getPage(Integer page) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();

        IPage<SaleInfo> saleInfoIPage = new Page<>(page, 10);
        QueryWrapper<SaleInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("saleid");
        queryWrapper.eq("stoid", user.getStoid());
        List<SaleInfo> saleInfos = saleInfoMapper.selectPage(saleInfoIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        List<JSONObject> items = new LinkedList<>();
        for (SaleInfo saleInfo : saleInfos) {
            saleInfo = saleInfoMapper.selectById(saleInfo.getSaleId());
            JSONObject item = new JSONObject();

            item.put("saleId", saleInfo.getSaleId());
            item.put("stoAddr", saleInfo.getStoAddr());
            item.put("stoName", saleInfo.getStoName());
            item.put("profit", saleInfo.getProfit());
            item.put("error_message", "success");
            items.add(item);
        }
        resp.put("saleinfos", items);
        resp.put("saleinfos_count", saleInfoMapper.selectCount(null));

        return resp;
    }
}

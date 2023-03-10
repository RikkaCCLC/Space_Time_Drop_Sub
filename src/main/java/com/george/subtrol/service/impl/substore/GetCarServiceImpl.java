package com.george.subtrol.service.impl.substore;

import com.george.subtrol.service.substore.GetCarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.Store;
import com.george.subtrol.utils.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetCarServiceImpl implements GetCarService {

    @Autowired
    StoreMapper storeMapper;

    @Override
    public List<Store> getCar() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();

        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stoid", user.getStoid());
        System.out.println(storeMapper.selectList(queryWrapper));
        return storeMapper.selectList(queryWrapper);
}}

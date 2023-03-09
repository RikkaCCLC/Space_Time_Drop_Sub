package com.george.subtrol.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Store user = storeMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }

        return new UserDetailsImpl(user);
    }
}

package com.george.subtrol.service.impl.account;

import com.george.subtrol.service.account.RegisterService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String, String> map = new HashMap<>();
        if (username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }
        if (password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();
        if (username.length() == 0) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        if (password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        if (username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if (password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码长度不能大于100");
            return map;
        }

        if (!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<Store> users = storeMapper.selectList(queryWrapper);
        if (!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        String encodedPassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/1_lg_844c66b332.jpg";
//        User user = new User(null, username, encodedPassword, photo);
//        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}

package com.george.subtrol.service.impl.substore;

import com.george.subtrol.utils.UserDetailsImpl;
import com.george.subtrol.service.substore.UpdateService;
import com.george.subtrol.mapper.StoreMapper;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private StoreMapper storeMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();
        System.out.println(data.get("carnum"));
        Integer carnum = Integer.
                valueOf(data.get("carnum"));
        Map<String, String> map = new HashMap<>();

        Store user1 = new Store(
                user.getStoid(),
                user.getUsername(),
                user.getPassword(),
                user.getStoname(),
                user.getStoaddr(),
                carnum
        );
        storeMapper.updateById(user1);
        map.put("error_message", "success");
        return map;
    }
}

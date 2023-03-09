package com.george.subtrol.service.impl.substore;

import com.george.subtrol.utils.UserDetailsImpl;
import com.george.subtrol.service.substore.GetListService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.george.subtrol.mapper.SaleInfoMapper;
import com.george.subtrol.pojo.SaleInfo;
import com.george.subtrol.pojo.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetListServiceImpl implements GetListService {
    @Autowired
    private SaleInfoMapper saleInfoMapper;

    @Override
    public List<SaleInfo> getList() {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        Store user = loginUser.getUser();

        QueryWrapper<SaleInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stoid", user.getId());
        return saleInfoMapper.selectList(queryWrapper);
    }


}

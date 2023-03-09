package com.george.subtrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.subtrol.pojo.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StoreMapper extends BaseMapper<Store> {
    @Select("SELECT SUM(carnum) FROM Store")
    Integer getCarnumSum();
}

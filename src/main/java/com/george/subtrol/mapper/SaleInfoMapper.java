package com.george.subtrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.subtrol.pojo.SaleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaleInfoMapper extends BaseMapper<SaleInfo> {
    @Select("SELECT SUM(profit) as weekly_profit FROM saleinfo WHERE time >= DATEADD(wk, DATEDIFF(wk,0,GETDATE()), 0)")
    public Double getWeeklyProfit();

    @Select("SELECT SUM(profit) as monthly_profit FROM saleinfo WHERE MONTH(time) = MONTH(GETDATE()) AND YEAR(time) = YEAR(GETDATE())")
    public Double getMonthlyProfit();

    @Select("SELECT SUM(profit) as last_month_profit FROM saleinfo WHERE MONTH(time) = MONTH(DATEADD(month, -1, GETDATE())) AND YEAR(time) = YEAR(DATEADD(month, -1, GETDATE()))")
    public Double getLastMonthProfit();
}

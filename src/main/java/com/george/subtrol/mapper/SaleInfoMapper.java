package com.george.subtrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.george.subtrol.pojo.SaleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SaleInfoMapper extends BaseMapper<SaleInfo> {
    @Select("SELECT s.${stoid}, SUM(s1.profit) AS weekly_profit FROM store s INNER JOIN saleinfo s1 ON s.stoid = s1.stoid WHERE s1.time >= DATE_ADD(DATE(NOW()), INTERVAL 1-DAYOFWEEK(NOW()) DAY) GROUP BY s.stoid")
    public Double getWeeklyProfit(@Param("stoid") int stoid);

    @Select("SELECT s.${stoid}, SUM(s1.profit) AS monthly_profit FROM store s INNER JOIN saleinfo s1 ON s.stoid = s1.stoid WHERE YEAR(s1.time) = YEAR(NOW()) AND MONTH(s1.time) = MONTH(NOW()) GROUP BY s.stoid")
    public Double getMonthlyProfit();

    @Select("SELECT s.${stoid}, SUM(s1.profit) AS last_month_profit FROM store s INNER JOIN saleinfo s1 ON s.stoid = s1.stoid WHERE YEAR(s1.time) = YEAR(NOW() - INTERVAL 1 MONTH) AND MONTH(s1.time) = MONTH(NOW() - INTERVAL 1 MONTH) GROUP BY s.stoid")
    public Double getLastMonthProfit();
}

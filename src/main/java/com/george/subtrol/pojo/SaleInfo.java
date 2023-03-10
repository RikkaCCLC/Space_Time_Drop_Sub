package com.george.subtrol.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "saleinfo")
public class SaleInfo {
    @TableId(value = "saleid", type = IdType.AUTO)
    private Integer saleId;
    @TableField(value = "stoid")
    private Integer stoId;
    @TableField(value = "stoname")
    private String stoName;
    @TableField(value = "stoaddr")
    private String stoAddr;
    @TableField(value = "time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createtime;
    @TableField(value = "profit")
    private Double profit;

}

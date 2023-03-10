package com.george.subtrol.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @TableId(value = "stoid",type = IdType.AUTO)
    private Integer stoid;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "stoname")
    private String stoname;
    @TableField(value = "stoaddr")
    private String stoaddr;
    @TableField(value = "carnum")
    private Integer carnum;
}

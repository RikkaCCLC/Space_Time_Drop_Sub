package com.george.subtrol.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String stoname;
    private String stoaddr;
    private Integer carnum;
}

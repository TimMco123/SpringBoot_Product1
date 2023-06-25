package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer uId;

    @TableField("u_username")
    private String uUsername;

    @TableField("u_password")
    private String uPassword;

    @TableField("u_phone")
    private String uPhone;

    @TableField("u_date")
    private Date uDate;

    @TableField("u_role_id")
    private Integer uRoleId;

    @TableField(exist = false)
    private Role role;

    public User(Integer uId, String uUsername, String uPassword, String uPhone, Date uDate, Integer uRoleId) {
        this.uId = uId;
        this.uUsername = uUsername;
        this.uPassword = uPassword;
        this.uPhone = uPhone;
        this.uDate = uDate;
        this.uRoleId = uRoleId;
    }
}

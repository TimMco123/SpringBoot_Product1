package com.xiong.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("cinema")
public class Cinema {
    @TableId(value = "c_id", type = IdType.AUTO)
    private Integer cId;

    @TableField("c_name")
    private String cName;

    @TableField("c_phone")
    private String cPhone;

    @TableField("c_address")
    private String cAddress;

    @TableField("c_date")
    private Date cDate;

    @TableField(exist = false)
    private List<Movie> movieList;

    public Cinema(Integer cId, String cName, String cPhone, String cAddress, Date cDate) {
        this.cId = cId;
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cDate = cDate;
    }
}

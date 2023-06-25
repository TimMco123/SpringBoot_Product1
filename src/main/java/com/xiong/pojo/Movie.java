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
@TableName("movie")
public class Movie {
    @TableId(value = "m_id", type = IdType.AUTO)
    private Integer mId;

    @TableField("m_name")
    private String mName;

    @TableField("m_date")
    private Date mDate;

    @TableField("m_country")
    private String mCountry;

    @TableField(exist = false)
    private List<Cinema> cinemaList;

    public Movie(Integer mId, String mName, Date mDate, String country) {
        this.mId = mId;
        this.mName = mName;
        this.mDate = mDate;
        this.mCountry = country;
    }
}

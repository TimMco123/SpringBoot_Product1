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
@TableName("ticket")
public class Ticket {
    @TableId(value = "t_id", type = IdType.AUTO)
    private Integer tId;

    @TableField("t_movie")
    private Integer tMovie;

    @TableField("t_cinema")
    private Integer tCinema;

    @TableField("t_date")
    private Date tDate;

    @TableField("t_user")
    private Integer tUser;

    @TableField(exist = false)
    private Movie movie;

    @TableField(exist = false)
    private Cinema cinema;

    @TableField(exist = false)
    private User user;

    public Ticket(Integer tId, Integer tMovie, Integer tCinema, Date tDate, Integer tUser) {
        this.tId = tId;
        this.tMovie = tMovie;
        this.tCinema = tCinema;
        this.tDate = tDate;
        this.tUser = tUser;
    }
}

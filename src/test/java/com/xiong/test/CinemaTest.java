package com.xiong.test;

import com.xiong.pojo.Cinema;
import com.xiong.pojo.Movie;
import com.xiong.service.CinemaService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class CinemaTest {
    @Autowired
    private CinemaService cinemaService;

    @Test
    public void test() {
        cinemaService.list().forEach(System.out::println);
    }

    //查询所有的电影院，并关联查询电影
    @Test
    public void getAllCinemaAndMovieTest() {
        List<Cinema> cinemaList = cinemaService.getAllCinemaAndMovie();
        for (Cinema cinema : cinemaList) {
            System.out.println("---------------------------------");
            System.out.println(cinema);
            for (Movie movie : cinema.getMovieList()) {
                System.out.println(movie);
            }
        }
    }

    //根据ID查询电影院，并关联查询相关的电影信息
    @Test
    public void getCinemaAndMovieByIdTest() {
        Cinema cinema = cinemaService.getCinemaAndMovieById(3);
        System.out.println(cinema);
        for (Movie movie : cinema.getMovieList()) {
            System.out.println(movie);
        }
    }

    //查询所有的电影院，单表查询，分页+模糊
    @Test
    public void getByPageTest() {
        cinemaService.getByPage(2, 10, "影").forEach(System.out::println);
    }
}

package com.xiong.test;

import com.xiong.pojo.Cinema;
import com.xiong.pojo.Movie;
import com.xiong.service.MovieService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class MovieTest {
    @Autowired
    private MovieService movieService;

    @Test
    public void test() {
        movieService.list().forEach(System.out::println);
    }

    //查询所有的电影信息，并关联查询相关的电影院信息
    @Test
    public void getMovieAndCinemaTest() {
        List<Movie> movieList = movieService.getAllMovieAndCinema();
        for (Movie movie : movieList) {
            System.out.println("----------------------------------------");
            System.out.println(movie);
            for (Cinema cinema : movie.getCinemaList()) {
                System.out.println(cinema);
            }
        }
    }

    //根据ID查询电影信息，并关联查询相关的电影院信息
    @Test
    public void getMovieAndCinemaByIdTest() {
        Movie movie = movieService.getMovieAndCinemaById(6);
        for (Cinema cinema : movie.getCinemaList()) {
            System.out.println(cinema);
        }
    }

    //模糊查询+分页
    @Test
    public void getByPageTest() {
        movieService.getByPage(1, 10, "小").forEach(System.out::println);
    }

    //总记录数
    @Test
    public void getCountTest() {
        long total = movieService.getCount("小");
        System.out.println(total);
    }
}

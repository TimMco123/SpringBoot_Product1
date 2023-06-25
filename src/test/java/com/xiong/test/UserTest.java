package com.xiong.test;

import com.xiong.pojo.User;
import com.xiong.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class UserTest {
    @Autowired
    private UserService userService;

    //纯测试
    @Test
    public void test() {

    }

    //登录
    @Test
    public void loginTest() {
        User user = new User();
        user.setUUsername("熊熊");
        user.setUPassword("123456");
        user.setURoleId(1);
        User login = userService.login(user);
        System.out.println(login);
    }

    //查询所有，只有User表
    @Test
    public void getAllUserTest() {
        userService.list().forEach(System.out::println);
    }

    //根据ID更改用户信息
    @Test
    public void updateUserTest() {
        User user = new User();
        user.setUId(4);
        user.setUPassword("999999");
        user.setUPhone("1999999999");
        boolean flag = userService.updateById(user);
        System.out.println("flag:" + flag);
    }

    //添加User
    @Test
    public void addUserTest() {
        boolean flag = userService.save(new User(null, "千一", "100001", "1000000001", new Date(), 2));
        System.out.println("flag:" + flag);
    }

    //用户名是否重复
    @Test
    public void checkNameTest() {
        boolean flag = userService.checkName("熊熊1");
        if (flag) {
            System.out.println("不可用，有重复名字");
        } else {
            System.out.println("可用，没有重复名字");
        }
    }

    //查询所有的User，并关联查询Role
    @Test
    public void getAllUserAndRole() {
        userService.getAllUserAndRole(1, 10, null).forEach(System.out::println);
    }

    //分页查询+模糊查询
    @Test
    public void getByPageTest() {
        userService.getByPage(1, 5, "熊").forEach(System.out::println);
    }

    //查询count，有用户名时根据用户名模糊查询count
    @Test
    public void getCountTest() {
        long count = userService.getCount("熊");
        System.out.println(count);
    }
}

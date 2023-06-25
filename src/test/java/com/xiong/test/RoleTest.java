package com.xiong.test;

import com.xiong.service.RoleService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class RoleTest {
    @Autowired
    private RoleService roleService;

    //查询所有
    @Test
    public void getAllTest() {
        roleService.list().forEach(System.out::println);
    }
}

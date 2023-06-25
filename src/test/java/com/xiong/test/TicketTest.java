package com.xiong.test;

import com.xiong.pojo.Ticket;
import com.xiong.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan("com.xiong.dao")
public class TicketTest {
    @Autowired
    private TicketService ticketService;

    @Test
    public void test() {
        ticketService.list().forEach(System.out::println);
    }

    //查询所有，多表
    @Test
    public void getAllTest() {
        List<Ticket> ticketList = ticketService.getAll(1, 20);
        for (Ticket ticket : ticketList) {
            System.out.println("\n------------------------------------------------");
            System.out.println("tId=" + ticket.getTId() + ", tDate=" + ticket.getTDate());
            System.out.println(ticket.getUser());
            System.out.println(ticket.getCinema());
            System.out.println(ticket.getMovie());
        }
    }

    //查询记录数
    @Test
    public void getCountTest() {
        long total = ticketService.getCount();
        System.out.println(total);
    }

    //添加
    @Test
    public void addTest() {
        ticketService.save(new Ticket(null, 1, 1, new Date(), 1));

    }

    //查询所有，多表，没有分页
    @Test
    public void getAll1Test() {
        List<Ticket> ticketList = ticketService.getAll1();
        for (Ticket ticket : ticketList) {
            System.out.println("\n------------------------------------------------");
            System.out.println("tId=" + ticket.getTId() + ", tDate=" + ticket.getTDate());
            System.out.println(ticket.getUser());
            System.out.println(ticket.getCinema());
            System.out.println(ticket.getMovie());
        }
    }

    //根据ID查询，多表
    @Test
    public void getTicketById() {
        System.out.println(ticketService.getTicketById(15));
    }
}

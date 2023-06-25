package com.xiong.controller;

import com.xiong.pojo.Ticket;
import com.xiong.service.TicketService;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    //删除
    @RequestMapping("deleteTicket")
    public String deleteTicket(HttpServletRequest request,
                               @RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam("tId") Integer id) {
        System.out.println("\n进入deleteTicket控制器");
        ticketService.removeById(id);
        request.setAttribute("ticketList", ticketService.getAll(currentPage, pageSize));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) ticketService.getCount()));
        return "ticketPage/ticketList";
    }

    //添加
    @RequestMapping("addTicket")
    public String addTicket(Ticket ticket, HttpServletRequest request) {
        System.out.println("\n进入addTicket控制器");
        ticket.setTDate(new Date());
        ticketService.save(ticket);
        request.setAttribute("ticketInfo", ticketService.getTicketById(ticket.getTId()));
        return "ticketPage/ticketSuccess";//跳转，打印刚刚的数据
    }
}

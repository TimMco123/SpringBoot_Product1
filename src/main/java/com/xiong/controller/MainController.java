package com.xiong.controller;

import com.xiong.pojo.Ticket;
import com.xiong.service.*;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TicketService ticketService;

    //进入login页面，并传递Role
    @RequestMapping("login")
    public String loginPage(HttpServletRequest request) {
        System.out.println("\n进入login页面");
        request.setAttribute("roleList", roleService.list());
        return "userPage/login";
    }

    //进入register页面
    @RequestMapping("register")
    public String registerPage() {
        System.out.println("\n进入registerPage页面");
        return "userPage/register";
    }

    //进入userList页面，并传递User以及对应的Role
    @RequestMapping("userList")
    public String userList(HttpServletRequest request,
                           @RequestParam(defaultValue = "1") Integer currentPage,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "", value = "uUsername") String uUsername) {
        System.out.println("\n进入userList页面");
        if ("".equals(uUsername)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", uUsername);
        }
        request.setAttribute("userList", userService.getAllUserAndRole(currentPage, pageSize, uUsername));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) userService.getCount(uUsername)));
        return "userPage/userList";
    }

    //进入addUser页面
    @RequestMapping("addUserForAdmin")
    public String addUserForAdmin(HttpServletRequest request) {
        System.out.println("\n进入addUserForAdmin页面");
        request.setAttribute("roleList", roleService.list());
        return "userPage/addUser";
    }

    //进入cinemaList页面，电影院列表
    @RequestMapping("cinemaList")
    public String cinemaList(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "cName") String name) {
        System.out.println("\n进入cinemaList页面");
        if ("".equals(name)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", name);
        }
        request.setAttribute("cinemaList", cinemaService.getByPage(currentPage, pageSize, name));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) cinemaService.getCount(name)));
        return "cinemaPage/cinemaList";
    }

    //进入movieList页面，电影列表
    @RequestMapping("movieList")
    public String movieList(HttpServletRequest request,
                            @RequestParam(defaultValue = "1") Integer currentPage,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            @RequestParam(defaultValue = "", value = "mName") String name) {
        System.out.println("\n进入movieList页面");
        if ("".equals(name)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", name);
        }
        request.setAttribute("movieList", movieService.getByPage(currentPage, pageSize, name));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) movieService.getCount(name)));
        return "moviePage/movieList";
    }

    //进入ticketList页面，电影票列表
    @RequestMapping("ticketList")
    public String ticketList(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        System.out.println("\n进入ticketList页面");
        request.setAttribute("ticketList", ticketService.getAll(currentPage, pageSize));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) ticketService.getCount()));
        return "ticketPage/ticketList";
    }

    //进入addTicket页面，购票页面，选择电影
    @RequestMapping("addTicket")
    public String addTicket(HttpServletRequest request) {
        System.out.println("\n进入addTicket页面");
        request.setAttribute("movieList", movieService.list());
        return "ticketPage/addTicket";
    }

    //进入addTicket1页面，购票页面，选择影院
    @RequestMapping("addTicket1")
    public String addTicket1(Ticket ticket, HttpServletRequest request) {
        System.out.println("\n进入addTicket1页面");
        System.out.println(ticket);
        request.setAttribute("movieId", ticket.getTMovie());
        request.setAttribute("movie", movieService.getMovieAndCinemaById(ticket.getTMovie()));
        return "ticketPage/addTicket1";
    }
}

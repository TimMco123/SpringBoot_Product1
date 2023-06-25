package com.xiong.controller;

import com.xiong.pojo.User;
import com.xiong.service.RoleService;
import com.xiong.service.TicketService;
import com.xiong.service.UserService;
import com.xiong.utils.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TicketService ticketService;

    //登录
    @RequestMapping("login")
    @ResponseBody
    public boolean login(User user, HttpSession session) {
        System.out.println("\n进入login控制器");
        System.out.println(user);
        User login = userService.login(user);
        System.out.println(login);
        if (login != null) {
            System.out.println("登录成功");
            session.setAttribute("userInfo", login);
            return true;
        } else {
            System.out.println("登录失败");
            return false;
        }
    }

    //退出登录
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session) {
        System.out.println("\n进入loginOut控制器");
        session.invalidate();
        return "redirect:/";
    }

    //验证用户名是否可用session取值
    @RequestMapping("checkName")
    @ResponseBody
    public boolean checkName(User user, HttpSession session) {
        System.out.println("\n进入checkName控制器");
        User userInfo = (User) session.getAttribute("userInfo");
        if (userInfo != null) {
            if (Objects.equals(userInfo.getUUsername(), user.getUUsername())) {
                return false;
            }
        }
        if ("".equals(user.getUUsername())) {
            return true;
        }
        return userService.checkName(user.getUUsername());
    }

    //验证用户名是否可用getById取值
    @RequestMapping("checkName1")
    @ResponseBody
    public boolean checkName1(User user) {
        System.out.println("\n进入checkName控制器");
        User userInfo = userService.getById(user.getUId());
        if (userInfo != null) {
            if (Objects.equals(userInfo.getUUsername(), user.getUUsername())) {
                return false;
            }
        }
        if ("".equals(user.getUUsername())) {
            return true;
        }
        return userService.checkName(user.getUUsername());
    }

    //根据ID查询update
    @RequestMapping("getUserById")
    public String getUserById(HttpServletRequest request, Integer id) {
        System.out.println("\n进入getUserById控制器");
        request.setAttribute("userInfo", userService.getById(id));
        return "userPage/update";
    }

    //根据ID修改update
    @RequestMapping("update")
    public String updateUser(User user, HttpSession session) {
        System.out.println("\n进入updateUser控制器");
        System.out.println(user);
        boolean flag = userService.updateById(user);
        System.out.println("flag:" + flag);
        if (flag) {
            session.setAttribute("userInfo", userService.login(user));
        }
        return "redirect:/";
    }

    //添加用户，注册成功自动登录
    @RequestMapping("register")
    public String addUser(User user, HttpSession session) {
        System.out.println("\n进入addUser控制器");
        user.setUDate(new Date());
        boolean flag = userService.save(user);
        if (flag) {
            session.setAttribute("userInfo", userService.login(user));
            return "redirect:/";
        }
        return "redirect:/main/login";
    }

    //删除用户
    @RequestMapping("deleteUser")
    public String deleteUser(HttpServletRequest request,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "uUsername") String uUsername,
                             @RequestParam("uId") Integer uId) {
        System.out.println("\n进入deleteUser控制器");
        userService.removeById(uId);
        if (ticketService.getTicketByUser(uId) != null) {
            ticketService.deleteTicketByUser(uId);
        }
        if ("".equals(uUsername)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", uUsername);
        }
        request.setAttribute("userList", userService.getAllUserAndRole(currentPage, pageSize, uUsername));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) userService.getCount(uUsername)));
        return "userPage/userList";
    }

    //根据ID查询updateList
    @RequestMapping("getUserById1")
    public String getUserById1(HttpServletRequest request,
                               @RequestParam("uId") Integer uId,
                               @RequestParam(defaultValue = "", value = "uUsername") String uUsername) {
        System.out.println("\n进入getUserById1控制器");
        request.setAttribute("uUsername", uUsername);
        request.setAttribute("userInfo", userService.getById(uId));
        request.setAttribute("roleList", roleService.list());
        return "userPage/updateList";
    }

    //修改用户updateList
    @RequestMapping("updateUser")
    public String updateUser(HttpServletRequest request,
                             User user,
                             @RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer pageSize,
                             @RequestParam(defaultValue = "", value = "uUsername") String name) {
        System.out.println("\n进入updateUser控制器");
        System.out.println(user);
        if ("".equals(name)) {
            request.setAttribute("name1", "");
        } else {
            request.setAttribute("name1", name);
        }
        request.setAttribute("userList", userService.getAllUserAndRole(currentPage, pageSize, name));
        request.setAttribute("pages", new Pages(currentPage, pageSize, (int) userService.getCount(name)));
        userService.updateById(user);
        return "forward:/main/userList";
    }

    //管理员添加用户
    @RequestMapping("addUserForAdmin")
    public String addUserForAdmin(User user) {
        System.out.println("\n进入addUserForAdmin控制器");
        user.setUDate(new Date());
        userService.save(user);
        return "forward:/main/userList";
    }
}

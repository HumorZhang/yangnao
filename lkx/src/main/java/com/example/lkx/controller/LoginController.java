package com.example.lkx.controller;


import com.example.lkx.pojo.User;
import com.example.lkx.pojo.onlineUser;
import com.example.lkx.service.UserService;
import com.example.lkx.service.onlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    onlineService onlineService;

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/detail")
    public String detail(Model model,
                         HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user;
        if (userName == null) return "login";

            user = new User(userName, password);
            User u = userService.checkUser(user);
            if (u == null) return "login";
            List<onlineUser> list = onlineService.selectAll();
            model.addAttribute("user", u);
            model.addAttribute("list",list);
            request.getSession().setAttribute("user", u);
            return "userList";

    }




    @GetMapping(value = "/homepage")
    public String adminhomepage(Model model,
                                HttpServletRequest request){
        List<onlineUser> list = onlineService.selectAll();

        model.addAttribute("list",list);
        return "userList";
    }

}

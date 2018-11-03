package com.zgg.controller;

import com.zgg.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * zgg
 * 2018/10/30 12:28
 */
@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/")
    public String first(){
        return "login";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {

        if (userMapper.findUserByUsername(username).equals(password)) {
           session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        }else
        {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

}

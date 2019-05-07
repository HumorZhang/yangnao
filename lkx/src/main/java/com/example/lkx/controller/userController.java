package com.example.lkx.controller;



import com.example.lkx.pojo.onlineUser;
import com.example.lkx.service.onlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/wx")
public class userController {

    @Autowired
    onlineService onlineService;

    @RequestMapping("/userList")
    public void doLogin(HttpServletResponse resp, HttpServletRequest req){
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setContentType("text/html;charset=UTF-8");

        String nickName = req.getParameter("name");
        String avatarUrl = req.getParameter("url");
        onlineUser ab=onlineService.selectByname(nickName);
        System.out.println(ab.toString());
        if(nickName.equals(ab.getUsername())){
            System.out.println("已插入");
        }else{
            onlineUser onlineUser = new onlineUser();
            onlineUser.setUsername(nickName);
            onlineUser.setUrl(avatarUrl);
            onlineService.insertOnline(onlineUser);
        }

    }
}

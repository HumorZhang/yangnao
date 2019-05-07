package com.example.lkx.service;



import com.example.lkx.pojo.onlineUser;

import java.util.List;

public interface onlineService {
    int insertOnline(onlineUser onlineuser);
    List<onlineUser> selectAll();
    onlineUser selectByname(String username);
}

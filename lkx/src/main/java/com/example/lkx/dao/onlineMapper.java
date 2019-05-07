package com.example.lkx.dao;


import com.example.lkx.pojo.onlineUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface onlineMapper {
    int insertOnline(onlineUser onlineuser);
    List<onlineUser> selectAll();
    onlineUser selectByname(String username);
}

package com.example.lkx.dao;


import com.example.lkx.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    //通过username和passwd 验证用户 reader
    User checkUser(@Param("user") User user);

}

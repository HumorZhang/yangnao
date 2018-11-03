package com.zgg.mapper;

import com.zgg.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * zgg
 * 2018/11/3 14:29
 */
@Mapper
public interface UserMapper {

    @Select("select password from user where username=#{username}")
    public String findUserByUsername(String username);
}

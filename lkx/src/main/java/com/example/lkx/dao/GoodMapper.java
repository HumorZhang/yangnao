package com.example.lkx.dao;



import com.example.lkx.pojo.Good;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodMapper {

    List<Good> selectAll();

    List<Good> selectByType(int type);

    Good selectById(int id);
}

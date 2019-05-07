package com.example.lkx.service;


import com.example.lkx.pojo.Good;

import java.util.List;

public interface goodService {
    List<Good> selectAll();

    List<Good> selectByType(int type);

    Good selectById(int id);

}

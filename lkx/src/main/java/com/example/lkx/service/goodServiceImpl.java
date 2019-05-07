package com.example.lkx.service;


import com.example.lkx.dao.GoodMapper;
import com.example.lkx.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class goodServiceImpl implements goodService {
    @Autowired
    GoodMapper goodMapper;

    @Override
    public List<Good> selectAll() {
        return goodMapper.selectAll();
    }

    @Override
    public List<Good> selectByType(int type) {
        return goodMapper.selectByType(type);
    }

    @Override
    public Good selectById(int id) {
        return goodMapper.selectById(id);
    }
}

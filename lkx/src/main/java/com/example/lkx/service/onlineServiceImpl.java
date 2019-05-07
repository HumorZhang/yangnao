package com.example.lkx.service;


import com.example.lkx.dao.onlineMapper;
import com.example.lkx.pojo.onlineUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class onlineServiceImpl implements onlineService {
    @Autowired
    onlineMapper onlinemapper;

    @Override
    public int insertOnline(onlineUser onlineuser) {
        return onlinemapper.insertOnline(onlineuser);
    }

    @Override
    public List<onlineUser> selectAll() {
        return onlinemapper.selectAll();
    }

    @Override
    public onlineUser selectByname(String username) {
        return onlinemapper.selectByname(username);
    }
}

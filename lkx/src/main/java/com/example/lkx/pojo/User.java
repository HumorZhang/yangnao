package com.example.lkx.pojo;

import lombok.Data;

@Data
public class User {
    private String userName;
    private String passWd;
    public User(String userName, String passWd) {
        this.userName = userName;
        this.passWd = passWd;
    }

    public User() {}
}

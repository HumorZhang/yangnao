package com.example.lkx.pojo;

import lombok.Data;

@Data
public class onlineUser {
    private String username;
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "onlineUser{" +
                "username='" + username + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

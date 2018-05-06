package com.lwb.bean;

import com.google.common.collect.ComparisonChain;

public class User implements Comparable<User> {

    private String userName;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public int compareTo(User that) {
        return ComparisonChain.start()
                .compare(this.password, that.password)
                .compare(this.userName, that.userName)
                .result();
    }
}

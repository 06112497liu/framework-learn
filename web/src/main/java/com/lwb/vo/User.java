package com.lwb.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import com.google.common.collect.ComparisonChain;

@Component
@ConfigurationProperties(prefix = "user")
@PropertySource("classpath:user.properties")
public class User implements Comparable<User> {

    private String userName;
    private String password;

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

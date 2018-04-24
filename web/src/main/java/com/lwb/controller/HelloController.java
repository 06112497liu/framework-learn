package com.lwb.controller;

import com.lwb.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private User user;

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/test02")
    public User test02() {
        System.out.println(34555555);
        return user;
    }
}

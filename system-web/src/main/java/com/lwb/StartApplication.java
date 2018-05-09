package com.lwb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude = {
        })
@MapperScan("com.lwb.dao")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}

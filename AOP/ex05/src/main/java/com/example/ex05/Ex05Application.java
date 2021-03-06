package com.example.ex05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // AOP사용에 대한 허가
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Ex05Application {

    public static void main(String[] args) {
        SpringApplication.run(Ex05Application.class, args);
    }

}

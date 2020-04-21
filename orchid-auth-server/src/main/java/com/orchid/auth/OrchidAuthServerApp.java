package com.orchid.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan({"com.orchid.**.dao"})
@RestController
public class OrchidAuthServerApp {

    public static void main(String[] args){
        SpringApplication.run(OrchidAuthServerApp.class, args);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}

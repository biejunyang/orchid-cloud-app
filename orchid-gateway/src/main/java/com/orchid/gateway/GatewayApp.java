package com.orchid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {

    public static void main(String[] args){
        SpringApplication.run(GatewayApp.class, args);
    }
}

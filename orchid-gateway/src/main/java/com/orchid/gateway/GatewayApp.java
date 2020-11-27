package com.orchid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {

    public static void main(String[] args){
        SpringApplication.run(GatewayApp.class, args);
    }


    /**
     * 限流熔断回退
     */
    @RestController
    public class FallbackController {
        @GetMapping("/fallback")
        public String fallback() {
            return "fallback";
        }
    }
}

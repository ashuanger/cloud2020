package com.xsz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard {

    public static void main(String[] args){
        SpringApplication.run(ConsumerHystrixDashboard.class,args);
    }
}

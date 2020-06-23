package com.xsz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8015 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8015.class,args);
    }
}

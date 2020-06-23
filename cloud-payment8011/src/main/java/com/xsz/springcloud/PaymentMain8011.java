package com.xsz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8011 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8011.class,args);
    }
}

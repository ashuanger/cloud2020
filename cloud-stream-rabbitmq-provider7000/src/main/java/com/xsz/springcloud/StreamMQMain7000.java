package com.xsz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class StreamMQMain7000 {

    public static void main(String[] args){
        SpringApplication.run(StreamMQMain7000.class,args);
    }
}

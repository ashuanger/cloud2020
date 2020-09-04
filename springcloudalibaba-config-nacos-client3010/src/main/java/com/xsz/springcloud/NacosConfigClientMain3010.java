package com.xsz.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3010 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3010.class,args);
    }
}

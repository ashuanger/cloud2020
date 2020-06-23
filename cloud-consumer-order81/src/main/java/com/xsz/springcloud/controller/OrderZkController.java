package com.xsz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/orderZk")
public class OrderZkController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/payment/zk",method = RequestMethod.GET)
    public String paymentInfo(){
        String result=restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
        return result;
    }
}

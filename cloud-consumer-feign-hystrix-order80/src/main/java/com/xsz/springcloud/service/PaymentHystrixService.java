package com.xsz.springcloud.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PaymentHystrixService implements PaymentFeignService{

    @Override
    public String OK(Integer id) {
        return "======PaymentHystrixService fall back OK =====";
    }

    @Override
    public String TimeOut(Integer id) {
        return "======PaymentHystrixService fall back TimeOut =====";
    }
}

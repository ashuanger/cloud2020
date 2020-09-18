package com.xsz.springcloud.service;

import com.xsz.springcloud.entity.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider")
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public BaseResult paymentSQL(@PathVariable("id") Long id);
}

package com.xsz.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xsz
 */
@Component
@FeignClient(name="nacos-cloud-provider")
public interface PaymentService {


    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Long id);
}

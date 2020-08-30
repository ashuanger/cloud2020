package com.xsz.springcloud.service;

import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @RequestMapping(value = "/payment/add",method= RequestMethod.POST)
    public BaseResult add(@RequestBody Payment payment);

    @RequestMapping(value = "/payment/getList",method= RequestMethod.GET)
    public BaseResult getList();

    @RequestMapping(value = "/payment/get/{id}",method = RequestMethod.GET)
    public BaseResult getPaymentById(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/paymentFeignTimeOut")
    public String paymentFeignTimeOut();

    @GetMapping(value = "/payment/zipkin")
    public String paymentZipkin();
}

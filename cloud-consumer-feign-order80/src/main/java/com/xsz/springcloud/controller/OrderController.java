package com.xsz.springcloud.controller;


import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import com.xsz.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderController {


    @Resource
    PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/payment/createOrder",method= RequestMethod.POST)
    public BaseResult create(@RequestBody Payment payment){
        return paymentFeignService.add(payment);
    }

    @RequestMapping(value = "/payment/getList",method= RequestMethod.GET)
    public BaseResult getList(){
        return paymentFeignService.getList();
    }

    @RequestMapping(value = "/payment/get/{id}",method= RequestMethod.GET)
    public BaseResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }


}

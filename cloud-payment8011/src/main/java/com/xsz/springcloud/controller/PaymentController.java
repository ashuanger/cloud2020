package com.xsz.springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.xsz.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public BaseResult add(@RequestBody Payment payment){
        int resultCount=paymentService.add(payment);
        log.info("*****新增结果为:"+resultCount+"server.port:"+serverPort);
        if (resultCount>0){
            return Rsp.succ(resultCount);

        }
        return Rsp.fail(resultCount);
    }

    @RequestMapping(value = "/getList",method= RequestMethod.GET)
    public BaseResult getList(){


        return Rsp.succ(paymentService.getPaymentList());
    }


    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public BaseResult getPaymentById(@PathVariable("id") Long id){

        Payment payment=paymentService.getPaymentById(id);
        log.info("*****查询结果为:"+payment.toString()+"server.port:"+serverPort);
        return Rsp.succ("*****查询结果为:"+payment.toString()+"server.port:"+serverPort,payment);
    }




}

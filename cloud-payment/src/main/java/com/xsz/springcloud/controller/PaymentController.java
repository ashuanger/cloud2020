package com.xsz.springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import com.xsz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public Object discovery(){

        List<String> services=discoveryClient.getServices();
        for (String element:
             services) {
            log.info("****element："+element);
        }
        List<ServiceInstance> serviceInstanceList=discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance serviceInstance:
             serviceInstanceList) {
            log.info(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+
                    serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }


        return discoveryClient;
    }



}

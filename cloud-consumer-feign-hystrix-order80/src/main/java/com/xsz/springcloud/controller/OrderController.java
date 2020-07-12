package com.xsz.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xsz.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping(value = "/consumer")
//@DefaultProperties(defaultFallback = "globalFallBack")
public class OrderController {


    @Resource
    PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/hystrix/OK/{id}",method= RequestMethod.GET)
    public String OK(@PathVariable("id") Integer id){
        return paymentFeignService.OK(id);
    }


    @RequestMapping(value = "/hystrix/TimeOut/{id}",method= RequestMethod.GET)
//    @HystrixCommand
    //    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties={
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
//    @HystrixCommand
    public String TimeOut(@PathVariable("id") Integer id){
//        log.info("1233");
//        int age=10/0;
        return paymentFeignService.TimeOut(id);
    }

    //熔断方法
    public String paymentTimeOutFallbackMethod(Integer id){

        return "服务器连接超时啦";

    }


    //全局fallback
    public String globalFallBack(){
        log.info("globalFallBack异常处理");
        return "服务器处理请求异常";

    }

}

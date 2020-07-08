package com.xsz.springcloud.service;

import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "cloud-provider-hystrix-payment")
public interface PaymentFeignService {

    @RequestMapping(value = "/payment/hystrix/OK/{id}",method= RequestMethod.GET)
    public String OK(@PathVariable("id") Integer id);


    @RequestMapping(value = "/payment/hystrix/TimeOut/{id}",method= RequestMethod.GET)
    public String TimeOut(@PathVariable("id") Integer id);

}

package com.xsz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import com.xsz.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CirleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;


    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")//1.没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //2.fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //3.blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})//4.fallback和blockHandler都配置，exceptionsToIgnore是忽略的错误类型
    public BaseResult fallback(@PathVariable Long id){
        BaseResult result=restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,BaseResult.class);
        if (id == 4) {
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }else if (result.getData() == null) {
            throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    //本例是fallback
    public BaseResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id,"null");
        return Rsp.err("兜底异常handlerFallback,exception内容:"+e.getMessage(),payment);
    }

    //本例是blockHandler
    public BaseResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return Rsp.err("blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }


    //==================OpenFeign

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public BaseResult paymentSQL(@PathVariable("id") Long id)
    {
        return paymentService.paymentSQL(id);
    }

}

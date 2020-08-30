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
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
/**
 * 支付接口
 */
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 新增支付
     * @param payment 支付表实体
     * @return
     */
    @RequestMapping(value = "/add",method= RequestMethod.POST)
    public BaseResult add(@RequestBody Payment payment){
        int resultCount=paymentService.add(payment);
        log.info("*****新增结果为:"+resultCount+"server.port:"+serverPort);
        if (resultCount>0){
            return Rsp.succ(resultCount);

        }
        return Rsp.fail(resultCount);
    }

    /**
     * 获取支付列表
     * @return
     */
    @RequestMapping(value = "/getList",method= RequestMethod.GET)
    public BaseResult getList(){

        return Rsp.succ(paymentService.getPaymentList());
    }

    /**
     * 获取单个支付
     * @param id 编号
     * @return
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public BaseResult getPaymentById(@PathVariable("id") Long id){

        Payment payment=paymentService.getPaymentById(id);
        log.info("*****查询结果为:"+payment.toString()+"server.port:"+serverPort);
        return Rsp.succ("*****查询结果为:"+payment.toString()+"server.port:"+serverPort,payment);
    }

    /**
     * 获取服务列表
     * @return
     */
    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public BaseResult discovery(){

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
        return Rsp.succ(discoveryClient);
    }

    /**
     * 轮询
     * @return
     */
    @RequestMapping(value = "/lb")
    public String getPayment(){
        return serverPort;
    }

    /**
     * 超时控制
     * @return
     */
    @RequestMapping(value = "/paymentFeignTimeOut")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
        return serverPort;
    }


    @GetMapping("/zipkin")
    public String paymentZipkin()
    {
        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
    }

}

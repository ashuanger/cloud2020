package com.xsz.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import com.xsz.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public BaseResult byResource(){
        return Rsp.succ("按资源名称限流测试OK",new Payment(2020L,"serial001"));
    }

    public BaseResult handleException(BlockException exception)
    {
        return Rsp.err(exception.getClass().getCanonicalName()+"\t 服务不可用",null);
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public BaseResult byUrl()
    {
        return Rsp.succ("按url限流测试OK",new Payment(2020L,"serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public BaseResult customerBlockHandler()
    {
        return Rsp.succ("按url限流测试OK",new Payment(2020L,"serial003"));
    }
}

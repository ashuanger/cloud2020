package com.xsz.springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/zk",method= RequestMethod.GET)
    public BaseResult add(){
       return Rsp.succ("springCloud with zookeeper :"+serverPort+"\t"+ UUID.randomUUID().toString());
    }



}

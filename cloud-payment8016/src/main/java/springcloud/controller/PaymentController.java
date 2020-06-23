package springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/consult",method= RequestMethod.GET)
    public BaseResult add(){
       return Rsp.succ("springCloud with consult :"+serverPort+"  "+ UUID.randomUUID().toString());
    }



}

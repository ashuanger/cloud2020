package springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/payment/hystrix")
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    @Resource
    PaymentService paymentService;

    /**
     * 正常
     * @param id
     * @return
     */
    @RequestMapping(value = "/OK/{id}",method= RequestMethod.GET)
    public String OK(@PathVariable("id") Integer id){

        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result: "+result);
        return result;
    }

    /**
     * 潮湿
     * @param id
     * @return
     */
    @RequestMapping(value = "/TimeOut/{id}",method= RequestMethod.GET)
    public String TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result: "+result);
        return result;
    }



}

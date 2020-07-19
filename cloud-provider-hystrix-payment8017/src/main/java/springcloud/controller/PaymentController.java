package springcloud.controller;


import com.xsz.springcloud.common.Rsp;
import com.xsz.springcloud.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;
import springcloud.service.PaymentService2;

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

    @Resource
    PaymentService2 paymentService2;

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
     * 超时
     * @param id
     * @return
     */
    @RequestMapping(value = "/TimeOut/{id}",method= RequestMethod.GET)
    public String TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result: "+result);
        return result;
    }


    /**
     * 服务熔断
     * @param id
     * @return
     */
    @GetMapping("/circuit/{id}")
    public String circuit(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

    /**
     * 服务熔断2
     * @param id
     * @return
     */
    @GetMapping("/circuit2/{id}")
    public String circuit2(@PathVariable("id") Integer id)
    {
        String result = paymentService2.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }
}

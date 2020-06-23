package springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/orderConsul")
public class OrderConsulController {

    public static final String PAYMENT_URL="http://cloud-payment-consul-service";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/payment/consult",method = RequestMethod.GET)
    public String paymentInfo(){
        String result=restTemplate.getForObject(PAYMENT_URL+"/payment/consult",String.class);
        System.out.println(result);
        return result;
    }
}

package springcloud.controller;



import com.xsz.springcloud.entity.BaseResult;
import com.xsz.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "/consumer")
public class OrderController {

//    public static final String PAYMENT_URL="http://localhost:8010/payment";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;



    @RequestMapping(value = "/payment/createOrder",method= RequestMethod.POST)
    public BaseResult create(@RequestBody Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,BaseResult.class);
    }

    @RequestMapping(value = "/payment/getList",method= RequestMethod.GET)
    public BaseResult getList(){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/getList",BaseResult.class);
    }

    @RequestMapping(value = "/payment/get/{id}",method= RequestMethod.GET)
    public BaseResult getPaymentById(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,BaseResult.class);
    }


}

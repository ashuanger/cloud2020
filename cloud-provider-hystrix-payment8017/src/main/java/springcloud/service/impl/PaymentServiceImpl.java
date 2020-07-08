package springcloud.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import springcloud.service.PaymentService;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * 正常运行
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：  "+Thread.currentThread().getName()+"paymentInfo_ok :  " + id ;
    }

    /**
     * 超时
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        int timeNum=3;
        try {
            TimeUnit.SECONDS.sleep(timeNum);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
//        int age=10/0;
//        return "线程池：  "+Thread.currentThread().getName()+"paymentInfo_TimeOut :  " + id +"耗时"+5+"秒";

        return "线程池：  "+Thread.currentThread().getName()+"paymentInfo_TimeOut :  " + id +"耗时"+timeNum+"秒";
    }

    //熔断方法
    public String paymentInfo_TimeOutHandler(Integer id){

        return "服务器出错啦";

    }


}

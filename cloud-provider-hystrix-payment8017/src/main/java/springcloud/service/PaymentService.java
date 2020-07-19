package springcloud.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    /**
     * 正常运行
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    /**
     * 超时
     * @param id
     * @return
     */
    public String paymentInfo_TimeOut(Integer id);

    /**
     * 熔断
     * @param id
     * @return
     */
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);

}

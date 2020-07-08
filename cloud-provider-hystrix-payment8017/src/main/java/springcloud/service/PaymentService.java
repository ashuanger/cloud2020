package springcloud.service;


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



}

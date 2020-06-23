package com.xsz.springcloud.service;

import com.xsz.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {

    public List<Payment> getPaymentList();

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

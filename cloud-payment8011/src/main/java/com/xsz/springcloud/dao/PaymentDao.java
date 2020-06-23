package com.xsz.springcloud.dao;

import com.xsz.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentDao {

    public List<Payment> getPaymentList();

    public int add(Payment payment);

    public Payment getPaymentById(Long id);

}

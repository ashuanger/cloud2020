package com.xsz.springcloud.service.impl;

import com.xsz.springcloud.entity.Payment;
import com.xsz.springcloud.dao.PaymentDao;
import com.xsz.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public List<Payment> getPaymentList() {

        return paymentDao.getPaymentList();
    }

    @Override
    public int add(Payment payment) {

        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {


        return paymentDao.getPaymentById(id);
    }
}

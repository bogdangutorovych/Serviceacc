package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Payment;

public interface PaymentService {

    Payment saveOrUpdate(Payment payment);

    Payment findById(Long paymentId);

    List<Payment> findAll();

    void delete(Long paymentId);
}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.repository.PaymentRepository;

@Service("paymentService")
public class PaymentServiceDataJpa implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Payment saveOrUpdate(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(Long paymentId) {
        return paymentRepository.findOne(paymentId);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void delete(Long paymentId) {
        paymentRepository.delete(paymentId);

    }

}

package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

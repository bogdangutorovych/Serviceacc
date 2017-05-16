package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.QueueRegister;

public interface QueueEnrollService {

    QueueRegister create(QueueRegister queueEnroll);

    QueueRegister update(QueueRegister queueEnroll);

    QueueRegister findById(Long queueEnrollId);

    List<QueueRegister> findAll();

    void delete(Long queueEnrollId);
}

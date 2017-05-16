package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.QueueRegister;

public interface QueueRegisterService {

    QueueRegister create(QueueRegister queueRegister);

    QueueRegister update(QueueRegister queueRegister);

    QueueRegister findById(Long queueRegisterId);

    List<QueueRegister> findAll();

    void delete(Long queueRegisterId);
}

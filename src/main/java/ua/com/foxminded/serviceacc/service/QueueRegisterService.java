package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.QueueRegister;

public interface QueueRegisterService {

    QueueRegister save(QueueRegister queueRegister);

    QueueRegister findById(Long queueRegisterId);

    List<QueueRegister> findAll();

    void delete(Long queueRegisterId);
}

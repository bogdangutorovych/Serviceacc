package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.QueueEnroll;

public interface QueueEnrollService {

    QueueEnroll create(QueueEnroll queueEnroll);

    QueueEnroll update(QueueEnroll queueEnroll);

    QueueEnroll findById(Long queueEnrollId);

    List<QueueEnroll> findAll();

    void delete(Long queueEnrollId);
}

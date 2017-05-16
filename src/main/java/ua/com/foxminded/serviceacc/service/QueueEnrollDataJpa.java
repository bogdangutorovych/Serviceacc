package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.repository.QueueEnrollRepository;

@Service("queueEnrollService")
public class QueueEnrollDataJpa implements QueueRegisterService {

    @Autowired
    QueueEnrollRepository queueEnrollRepository;

    @Override
    public QueueRegister create(QueueRegister queueEnroll) {
        return queueEnrollRepository.save(queueEnroll);
    }

    @Override
    public QueueRegister update(QueueRegister queueEnroll) {
        return queueEnrollRepository.save(queueEnroll);
    }

    @Override
    public QueueRegister findById(Long queueEnrollId) {
        return queueEnrollRepository.findOne(queueEnrollId);
    }

    @Override
    public List<QueueRegister> findAll() {
        return queueEnrollRepository.findAll();
    }

    @Override
    public void delete(Long queueEnrollId) {
        queueEnrollRepository.delete(queueEnrollId);

    }

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.QueueEnroll;
import ua.com.foxminded.serviceacc.repository.QueueEnrollRepository;

@Service("queueEnrollService")
public class QueueEnrollDataJpa implements QueueEnrollService {

    @Autowired
    QueueEnrollRepository queueEnrollRepository;

    @Override
    public QueueEnroll create(QueueEnroll queueEnroll) {
        return queueEnrollRepository.save(queueEnroll);
    }

    @Override
    public QueueEnroll update(QueueEnroll queueEnroll) {
        return queueEnrollRepository.save(queueEnroll);
    }

    @Override
    public QueueEnroll findById(Long queueEnrollId) {
        return queueEnrollRepository.findOne(queueEnrollId);
    }

    @Override
    public List<QueueEnroll> findAll() {
        return queueEnrollRepository.findAll();
    }

    @Override
    public void delete(Long queueEnrollId) {
        queueEnrollRepository.delete(queueEnrollId);

    }

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.QueueRegister;
import ua.com.foxminded.serviceacc.repository.QueueRegisterRepository;

@Service("queueRegisterService")
public class QueueRegisterServiceDataJpa implements QueueRegisterService {

    @Autowired
    QueueRegisterRepository queueRegisterRepository;

    @Override
    public QueueRegister save(QueueRegister queueRegister) {
        return queueRegisterRepository.save(queueRegister);
    }

    @Override
    public QueueRegister findById(Long queueRegisterId) {
        return queueRegisterRepository.findOne(queueRegisterId);
    }

    @Override
    public List<QueueRegister> findAll() {
        return queueRegisterRepository.findAll();
    }

    @Override
    public void delete(Long queueRegisterId) {
        queueRegisterRepository.delete(queueRegisterId);

    }

}

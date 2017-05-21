package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.repository.ManagerRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("managerService")
public class ManagerServiceDataJpa implements ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public Manager save(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager findById(Long managerId) {
        return managerRepository.findOne(managerId);
    }

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void delete(Long managerId) {
        managerRepository.delete(managerId);
    }

    @Override
    public List<Client> findClients(Manager manager) {
        return managerRepository.findAllByManager(manager);
    }

    @Override
    public int countClient(Manager manager) {
        return managerRepository.countClientByManager(manager);
    }
}

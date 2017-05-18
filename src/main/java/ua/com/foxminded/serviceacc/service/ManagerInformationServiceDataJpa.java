package ua.com.foxminded.serviceacc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.repository.ManagerInformationRepository;

@Service("managerInformationService")
public class ManagerInformationServiceDataJpa implements ManagerInformationService {

    @Inject
    ManagerInformationRepository managerInformationRepository;
    
    @Override
    public ManagerInformation save(ManagerInformation managerInformation) {
        return managerInformationRepository.save(managerInformation);
    }

    @Override
    public ManagerInformation update(ManagerInformation managerInformation) {
        return managerInformationRepository.save(managerInformation);
    }

    @Override
    public ManagerInformation findById(Long managerInformationId) {
        return managerInformationRepository.findOne(managerInformationId);
    }

    @Override
    public List<ManagerInformation> findAll() {
        return managerInformationRepository.findAll();
    }

    @Override
    public List<ManagerInformation> findByManager(Manager manager) {
        return managerInformationRepository.findByManager(manager);
    }

    @Override
    public void delete(Long managerInformationId) {
        managerInformationRepository.delete(managerInformationId);
    }

}

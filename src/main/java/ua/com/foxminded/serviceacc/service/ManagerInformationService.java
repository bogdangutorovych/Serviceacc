package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;

public interface ManagerInformationService {

    ManagerInformation save(ManagerInformation managerInformation);

    ManagerInformation findById(Long managerInformationId);

    List<ManagerInformation> findAll();

    List<ManagerInformation> findByManager(Manager manager);

    void delete(Long managerInformationId);

    ManagerInformation findByTypeAndManager(ManagerInformationType type, Manager manager);
}

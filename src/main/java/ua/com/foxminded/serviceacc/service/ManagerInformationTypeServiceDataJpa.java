package ua.com.foxminded.serviceacc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.repository.ManagerInformationTypeRepository;

import java.util.List;

/**
 * Created by andreb on 04.04.17.
 */
@Service("managerInformationTypeService")
public class ManagerInformationTypeServiceDataJpa implements ManagerInformationTypeService {

    @Autowired
    ManagerInformationTypeRepository managerInformationTypeRepository;

    @Override
    public ManagerInformationType save(ManagerInformationType managerInformationType) {
        return managerInformationTypeRepository.save(managerInformationType);
    }

    @Override
    public ManagerInformationType update(ManagerInformationType managerInformationType) {
        return managerInformationTypeRepository.save(managerInformationType);
    }

    @Override
    public ManagerInformationType findById(Long typeId) {
        return managerInformationTypeRepository.findOne(typeId);
    }

    @Override
    public ManagerInformationType findByTypeName(String typeName) {
        return managerInformationTypeRepository.findOneByTitle(typeName);
    }

    @Override
    public List<ManagerInformationType> findAll() {
        return managerInformationTypeRepository.findAll();
    }

    @Override
    public void delete(Long typeId) {
        managerInformationTypeRepository.delete(typeId);
    }
}

package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.repository.ManagerInformationTypeRepository;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;

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
    public ManagerInformationType findById(Long typeId) {
        return managerInformationTypeRepository.findOne(typeId);
    }

    @Override
    public List<ManagerInformationType> findAll() {
        return managerInformationTypeRepository.findAll();
    }

    @Override
    public void delete(Long typeId) {
        managerInformationTypeRepository.delete(typeId);
    }

    @Override
    public ManagerInformationType findByTitle(String title) {
        return managerInformationTypeRepository.findOneByTitle(title);
    }
}

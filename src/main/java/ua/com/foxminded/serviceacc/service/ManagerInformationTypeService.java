package ua.com.foxminded.serviceacc.service;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;

import java.util.List;

/**
 * Created by andreb on 04.04.17.
 */
public interface ManagerInformationTypeService {

    ManagerInformationType save(ManagerInformationType managerInformationType);
    ManagerInformationType update(ManagerInformationType managerInformationType);
    ManagerInformationType findById(Long typeId);
    ManagerInformationType findByTypeName(String typeName);
    List<ManagerInformationType> findAll();
    void delete(Long typeId);
}

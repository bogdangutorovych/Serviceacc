package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ManagerInformationType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ManagerInformationTypeService {

    ManagerInformationType save(ManagerInformationType managerInformationType);

    ManagerInformationType findById(Long typeId);

    List<ManagerInformationType> findAll();

    void delete(Long typeId);
}

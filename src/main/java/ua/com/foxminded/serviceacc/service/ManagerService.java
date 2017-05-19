package ua.com.foxminded.serviceacc.service;


import java.util.List;

import ua.com.foxminded.serviceacc.model.Manager;

/**
 * Created by andreb on 31.03.17.
 */
public interface ManagerService {

    Manager save(Manager manager);

    Manager findById(Long managerId);

    List<Manager> findAll();

    void delete(Long managerId);
}

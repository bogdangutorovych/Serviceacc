package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ClientStatusType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientStatusTypeService {

    ClientStatusType save(ClientStatusType clientStatusType);
    ClientStatusType update(ClientStatusType clientStatusType);
    ClientStatusType findById(Long clientStatusTypeId);
    ClientStatusType findByStatusName(String statusName);
    List<ClientStatusType> findAll();
    void delete(Long clientStatusTypeId);
}

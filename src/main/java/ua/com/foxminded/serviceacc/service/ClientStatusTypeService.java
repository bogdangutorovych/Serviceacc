package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ContractStatus;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientStatusTypeService {

    ContractStatus save(ContractStatus clientStatusType);
    ContractStatus update(ContractStatus clientStatusType);
    ContractStatus findById(Long clientStatusTypeId);
    ContractStatus findByStatusName(String statusName);
    List<ContractStatus> findAll();
    void delete(Long clientStatusTypeId);
}

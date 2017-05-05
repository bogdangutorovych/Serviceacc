package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ContractStatus;

/**
 * 
 */
public interface ContractStatusService {

    ContractStatus save(ContractStatus contractStatus);

    ContractStatus update(ContractStatus contractStatus);

    ContractStatus findById(Long contractStatusId);

    ContractStatus findByStatusTitle(String contractStatusTitle);

    List<ContractStatus> findAll();

    void delete(Long contractStatusId);
}

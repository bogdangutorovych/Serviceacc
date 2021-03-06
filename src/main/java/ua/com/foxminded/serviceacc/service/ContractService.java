package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Contract;

public interface ContractService {

    Contract save(Contract contract);

    Contract findById(Long contractId);

    List<Contract> findAll();

    void delete(Long contractId);

}

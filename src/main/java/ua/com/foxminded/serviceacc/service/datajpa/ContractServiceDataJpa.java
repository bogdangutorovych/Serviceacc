package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.repository.ContractRepository;
import ua.com.foxminded.serviceacc.service.ContractService;

@Service("contractService")
public class ContractServiceDataJpa implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract findById(Long contractId) {
        return contractRepository.findOne(contractId);
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void delete(Long contractId) {
        contractRepository.delete(contractId);
    }

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.repository.ContractRepository;

@Service("contractService")
public class ContractServiceDataJpa implements ContractService {
	
	@Autowired
	ContractRepository contractRepository;

	@Override
	public Contract create(Contract contract) {
		return contractRepository.save(contract);
	}

	@Override
	public Contract update(Contract contract) {
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

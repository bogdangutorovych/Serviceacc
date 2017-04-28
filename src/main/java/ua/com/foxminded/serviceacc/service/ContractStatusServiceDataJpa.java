package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ContractStatus;
import ua.com.foxminded.serviceacc.repository.ContractStatusRepository;

/**
 *
 */
@Service("contractStatusService")
public class ContractStatusServiceDataJpa implements ContractStatusService {

	@Autowired
	ContractStatusRepository contractStatusRepository;

	@Override
	public ContractStatus save(ContractStatus contractStatus) {
		return contractStatusRepository.save(contractStatus);
	}

	@Override
	public ContractStatus update(ContractStatus contractStatus) {
		return contractStatusRepository.save(contractStatus);
	}

	@Override
	public ContractStatus findById(Long contractStatusId) {
		return contractStatusRepository.findOne(contractStatusId);
	}

	@Override
	public List<ContractStatus> findAll() {
		return contractStatusRepository.findAll();
	}

	@Override
	public void delete(Long contractStatusTitleId) {
		contractStatusRepository.delete(contractStatusTitleId);
	}

	@Override
	public ContractStatus findByStatusTitle(String contractStatusTitle) {
		return contractStatusRepository.findOneByTitle(contractStatusTitle);
	}
}

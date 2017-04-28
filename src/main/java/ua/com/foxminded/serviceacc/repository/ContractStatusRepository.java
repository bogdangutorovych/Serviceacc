package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.ContractStatus;

public interface ContractStatusRepository extends JpaRepository<ContractStatus, Long> {
	ContractStatus findOneByTitle(String contractStatusTitle);
}

package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{

}

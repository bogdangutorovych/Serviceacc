package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.ContractStatus;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientStatusTypeRepository extends JpaRepository<ContractStatus, Long>, JpaSpecificationExecutor {
    ContractStatus findOneByTitle(String status);
}

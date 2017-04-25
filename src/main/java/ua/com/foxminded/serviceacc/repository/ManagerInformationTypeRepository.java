package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.ManagerInformationType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ManagerInformationTypeRepository extends JpaRepository<ManagerInformationType, Long>, JpaSpecificationExecutor {
    ManagerInformationType findOneByTitle(String typeName);
}

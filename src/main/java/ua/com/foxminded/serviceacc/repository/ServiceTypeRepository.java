package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.ServiceType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long>, JpaSpecificationExecutor {
	ServiceType findOneByTitle(String typeName);
}

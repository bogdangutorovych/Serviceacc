package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.PayStatus;
import ua.com.foxminded.serviceacc.model.ServiceType;

/**
 * Created by andreb on 04.04.17.
 */
public interface PayStatusRepository extends JpaRepository<PayStatus, Long>, JpaSpecificationExecutor {
	ServiceType findOneByTitle(String typeName);
}

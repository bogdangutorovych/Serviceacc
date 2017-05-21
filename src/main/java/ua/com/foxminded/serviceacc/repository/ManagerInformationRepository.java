package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;

public interface ManagerInformationRepository extends JpaRepository<ManagerInformation, Long>, JpaSpecificationExecutor {

    List<ManagerInformation> findByManager(Manager manager);

    ManagerInformation findOneByManagerInformationTypeAndManager(ManagerInformationType type, Manager manager);
}

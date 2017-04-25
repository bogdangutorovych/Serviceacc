package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.com.foxminded.serviceacc.model.ClientInformation;

public interface ClientInformationRepository extends JpaRepository<ClientInformation, Long>, JpaSpecificationExecutor {
}

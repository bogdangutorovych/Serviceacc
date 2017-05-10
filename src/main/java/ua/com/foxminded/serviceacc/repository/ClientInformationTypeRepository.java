package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.ClientInformationType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientInformationTypeRepository extends JpaRepository<ClientInformationType, Long> {
    
    ClientInformationType findOneByTitle(String typeName);
}
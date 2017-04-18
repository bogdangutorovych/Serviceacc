package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ua.com.foxminded.serviceacc.model.ClientStatusType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientStatusTypeRepository extends JpaRepository<ClientStatusType, Long>, JpaSpecificationExecutor {
    ClientStatusType findOneByTitle(String status);
}

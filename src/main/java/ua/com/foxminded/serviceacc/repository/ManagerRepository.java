package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Manager;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
    String fromContractByManager =
        "from Contract contract " +
        "inner join contract.deal deal " +
        "inner join deal.client client " +
        "inner join contract.manager manager " +
        "where contract.contractStatus = 'ACTIVE' and manager = ?1";

    List<Manager> findAllByOrderByIdAsc();

    @Query("SELECT distinct client " + fromContractByManager)
    List<Client> findAllByManager(Manager manager);

    @Query("SELECT count(distinct client) " + fromContractByManager)
    int countClientByManager(Manager manager);

}

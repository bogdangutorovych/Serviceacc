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
        "inner join deal.client c " +
        "inner join contract.manager m " +
        "where m = ?1";

    List<Manager> findAllByOrderByIdAsc();

    @Query("SELECT distinct c " + fromContractByManager)
    List<Client> findAllByManager(Manager manager);

    @Query("SELECT count(distinct c) " + fromContractByManager)
    int countClientByManager(Manager manager);

}

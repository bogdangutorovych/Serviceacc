package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ua.com.foxminded.serviceacc.model.Client;

import java.util.List;

/**
 * Created by andreb on 30.03.17.
 */
public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor {

	String eagerClient = "SELECT c FROM Client c " +
			"JOIN FETCH c.person " +
			"JOIN FETCH c.manager " +
			"JOIN FETCH c.status " +
			"JOIN FETCH c.level ";

	@Query(eagerClient)
	List<Client> findAllAndFetchPersonEagly();

	@Query("SELECT c FROM Client c JOIN FETCH c.clientHistory")
	List<Client> findAllAndFetchClientStatusHistoryEagly();

	@Query(eagerClient + "WHERE c.id = ?1")
	Client findOneEagerly(Long clientId);
}

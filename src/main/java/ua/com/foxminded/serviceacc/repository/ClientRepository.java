package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Client;

/**
 * Created by andreb on 30.03.17.
 */
public interface ClientRepository extends JpaRepository<Client, Long>, JpaSpecificationExecutor {

	String selectAllByJoinFetch = "SELECT c FROM Client c " +
			"LEFT JOIN FETCH c.level " +
			"LEFT JOIN FETCH c.status " +
			"LEFT JOIN FETCH c.manager ";

	@Query(selectAllByJoinFetch + "WHERE c.active = true")
	List<Client> findAllByFetch();

	@Query("SELECT c FROM Client c JOIN FETCH c.clientHistory")
	List<Client> findAllAndFetchClientStatusHistoryEagly();
	
	
}

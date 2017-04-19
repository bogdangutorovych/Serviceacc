package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Client;

/**
 * Created by andreb on 30.03.17.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

	/*
	 * String selectAllByJoinFetch = "SELECT c FROM Client c " +
	 * "LEFT JOIN FETCH c.level " + "LEFT JOIN FETCH c.status " +
	 * "LEFT JOIN FETCH c.manager ";
	 * 
	 * String selectActiveClient =
	 * "SELECT c FROM Client c WHERE c.active = true ";
	 * 
	 * @Query(selectActiveClient) List<Client> findAllByFetch();
	 * 
	 * @Query(selectActiveClient + "AND id = ?1") Client findOneActive(Long
	 * clientId);
	 * 
	 * @Query("SELECT c FROM Client c JOIN FETCH c.clientHistory") List<Client>
	 * findAllAndFetchClientStatusHistoryEagly();
	 */

}
package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.ClientStatusHistory;

/**
 * Created by andreb on 31.03.17.
 */
public interface ClientStatusHistoryRepository extends JpaRepository<ClientStatusHistory, Long> {

}

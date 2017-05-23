package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {
    List<Deal> findByClient(Client client);
}

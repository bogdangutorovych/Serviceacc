package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Manager;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByOrderByIdAsc();

}

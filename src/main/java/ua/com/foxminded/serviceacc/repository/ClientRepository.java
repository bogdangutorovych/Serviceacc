package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    public List<Client> findAllByOrderByIdAsc();
}

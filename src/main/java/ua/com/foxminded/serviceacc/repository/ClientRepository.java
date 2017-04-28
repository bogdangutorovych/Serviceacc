package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
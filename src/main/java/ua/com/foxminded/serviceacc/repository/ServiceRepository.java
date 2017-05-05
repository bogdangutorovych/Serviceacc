package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}

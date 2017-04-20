package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}

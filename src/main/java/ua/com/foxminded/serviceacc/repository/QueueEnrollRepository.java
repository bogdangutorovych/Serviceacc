package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.QueueRegister;

public interface QueueEnrollRepository extends JpaRepository<QueueRegister, Long> {

}

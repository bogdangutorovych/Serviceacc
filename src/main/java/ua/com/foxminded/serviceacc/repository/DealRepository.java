package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Deal;

public interface DealRepository extends JpaRepository<Deal, Long> {

}

package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Period;

public interface PeriodRepository extends JpaRepository<Period, Long> {

}

package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Money;

public interface MoneyRepository extends JpaRepository<Money, Long> {

}

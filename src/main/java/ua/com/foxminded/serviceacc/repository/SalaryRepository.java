package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}

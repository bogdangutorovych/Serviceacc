package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    @Query(value = "select salary from Salary salary where (salary.manager, salary.date) in "
            + "(select lastSalary.manager, max(lastSalary.date) from Salary lastSalary group by lastSalary.manager)")
    public List<Salary> findSalariesWithMaxDate();

}

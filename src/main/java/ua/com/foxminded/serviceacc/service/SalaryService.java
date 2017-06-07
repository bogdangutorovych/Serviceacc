package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Salary;

public interface SalaryService {
    Salary save(Salary salary);
    Salary findById(Long id);
    List<Salary> findAll();
    void delete(Long id);
    
    List<Salary> calculateSalaries();
    
    List<SalaryCalculationDetails> getSalaryCalculationDetails();
}

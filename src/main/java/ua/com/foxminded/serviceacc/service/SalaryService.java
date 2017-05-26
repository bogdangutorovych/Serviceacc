package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Salary;

@Service("salaryService")
public interface SalaryService {
    Salary save(Salary salary);
    Salary findById(Long id);
    List<Salary> findAll();
    void delete(Long id);
    
    List<Salary> calculateSalaries();
}

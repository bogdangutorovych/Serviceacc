package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.dto.PrepareSalaryInfo;

public interface SalaryService {
    Salary save(Salary salary);
    Salary findById(Long id);
    List<Salary> findAll();
    void delete(Long id);
    
    List<Salary> calculateSalaries();
    Salary calculateSalaryForManager(Manager manager);
    
    List<PrepareSalaryInfo> getPrepareSalaryInfoList();
    Salary getSalaryWithWorkStatements(Salary salary);
}

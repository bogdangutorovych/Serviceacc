package ua.com.foxminded.serviceacc.service;

import java.time.LocalDate;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Salary;

public class SalaryCalculationDetails {
    private Manager manager;
    private Salary lastSalary;
    private long workStatementCount;
    
    public SalaryCalculationDetails() {
    }
    
    
    public SalaryCalculationDetails(Manager manager, long workStatementCount) {
        super();
        this.manager = manager;
        this.workStatementCount = workStatementCount;
    }


    public Manager getManager() {
        return manager;
    }
    
    public boolean equalsManager(Manager manager) {
        if (this.manager.getId() == null || manager == null || manager.getId() == null) {
            return false;
        }
        
        return this.manager.getId().equals(manager.getId());
    }
    
    public String getManagerFullName() {
        return manager.getFirstName() + " " + manager.getLastName();
    }
    
    public String getManagerLastName() {
        return manager.getLastName();
    }
    
    public LocalDate getLastSalaryDate() {
        if (lastSalary == null) {
            return null;
        }
        
        return lastSalary.getDate();
    }
    
    public long getWorkStatementCount() {
        return workStatementCount;
    }
    
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setLastSalary(Salary lastSalary) {
        this.lastSalary = lastSalary;
    }

    public void setWorkStatementCount(long workStatementCount) {
        this.workStatementCount = workStatementCount;
    }
}

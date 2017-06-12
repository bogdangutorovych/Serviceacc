package ua.com.foxminded.serviceacc.service.dto;

import java.time.LocalDate;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Salary;

public class PrepareSalaryInfo {
    private Manager manager;
    private Salary lastSalary;
    private long workStatementCount;
    
    public PrepareSalaryInfo() {
    }
    
    
    public PrepareSalaryInfo(Manager manager, long workStatementCount) {
        super();
        this.manager = manager;
        this.workStatementCount = workStatementCount;
    }


    public Manager getManager() {
        return manager;
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

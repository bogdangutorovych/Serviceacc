package ua.com.foxminded.serviceacc.controller.salary;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Controller
@ViewScoped
@ManagedBean
public class SalariesCalculationController {
    private static final Logger log = LoggerFactory.getLogger(SalariesCalculationController.class);

    private SalaryService salaryService;
    
    private List<Salary> salaries = new ArrayList<Salary>();
    private Salary selectedSalary;
    
    public void calculateSalaries() {
        salaries = salaryService.calculateSalaries();
    }
    
    public SalariesCalculationController(SalaryService salaryService) {
        super();
        this.salaryService = salaryService;
    }

    public void onView() {
        
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public Salary getSelectedSalary() {
        return selectedSalary;
    }

    public void setSelectedSalary(Salary selectedSalary) {
        this.selectedSalary = selectedSalary;
    }
}

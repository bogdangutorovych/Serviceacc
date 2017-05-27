package ua.com.foxminded.serviceacc.controller.salary;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Named
@ViewScoped
public class SalariesCalculationController {
    private static final Logger log = LoggerFactory.getLogger(SalariesCalculationController.class);

    private SalaryService salaryService;
    
    private List<Salary> salaries = new ArrayList<Salary>();
    
    public void calculateSalaries() {
        salaries = salaryService.calculateSalaries();
    }
    
    @Inject
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

}

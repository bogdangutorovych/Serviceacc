package ua.com.foxminded.serviceacc.controller.salary;

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
public class SalaryDetailsController {
    private static final Logger log = LoggerFactory.getLogger(SalaryDetailsController.class);
    
    private SalaryService salaryService;
    
    private Salary selectedSalary;
    
    public SalaryDetailsController(SalaryService salaryService) {
        super();
        this.salaryService = salaryService;
    }

    public Salary getSelectedSalary() {
        return selectedSalary;
    }

    public void setSelectedSalary(Salary selectedSalary) {
        this.selectedSalary = selectedSalary;
    }    

}

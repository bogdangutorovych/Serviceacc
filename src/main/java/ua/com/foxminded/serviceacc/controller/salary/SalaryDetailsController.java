package ua.com.foxminded.serviceacc.controller.salary;

import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Named
@ViewScoped
public class SalaryDetailsController {
    private static final Logger log = LoggerFactory.getLogger(SalaryDetailsController.class);
    
    private static final long serialVersionUID = 1L;
    
    private final SalaryService salaryService;
    
    private Salary selectedSalary;
    
    @Inject
    public SalaryDetailsController(SalaryService salaryService) {
        super();
        this.salaryService = salaryService;
    }

    public void onGenerate() {
        selectedSalary.setDate(LocalDate.now());
        salaryService.save(selectedSalary);
    }
    
    public boolean getIsNewSalary() {
        return selectedSalary.getId() == null;
    }
    
    public Salary getSelectedSalary() {
        return selectedSalary;
    }

    public void setSelectedSalary(Salary selectedSalary) {
        this.selectedSalary = selectedSalary;
    }    
 
}

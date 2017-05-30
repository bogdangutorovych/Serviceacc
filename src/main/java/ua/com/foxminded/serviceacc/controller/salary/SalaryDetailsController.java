package ua.com.foxminded.serviceacc.controller.salary;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Salary;

@Named
@ViewScoped
public class SalaryDetailsController {
    private static final Logger log = LoggerFactory.getLogger(SalaryDetailsController.class);
    
    private static final long serialVersionUID = 1L;
    
    private Salary selectedSalary;
    
    public Salary getSelectedSalary() {
        return selectedSalary;
    }

    public void setSelectedSalary(Salary selectedSalary) {
        this.selectedSalary = selectedSalary;
    }    
 
    public void onGenerate() {
        
    }
}

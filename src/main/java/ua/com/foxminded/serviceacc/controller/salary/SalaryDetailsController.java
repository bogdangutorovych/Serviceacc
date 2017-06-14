package ua.com.foxminded.serviceacc.controller.salary;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.SalaryService;
import ua.com.foxminded.serviceacc.service.dto.PrepareSalaryInfo;

@Named
@ViewScoped
public class SalaryDetailsController implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SalaryDetailsController.class);
    
    private static final long serialVersionUID = 1L;
    
    private static enum SalaryDetailsAction {
        CALCULATE,
        EDIT
    };
    
    private final SalaryService salaryService;
    
    private Salary selectedSalary;
    
    private SalaryDetailsAction action = SalaryDetailsAction.EDIT;
    
    @Inject
    public SalaryDetailsController(SalaryService salaryService) {
        super();
        this.salaryService = salaryService;
    }

    public void createSalary(PrepareSalaryInfo salaryDetails) {
        selectedSalary = salaryService.calculateSalaryForManager(salaryDetails.getManager());
        this.action = SalaryDetailsAction.CALCULATE;
    }
    
    public void loadSalary() {
        selectedSalary = salaryService.getSalaryWithWorkStatements(selectedSalary);
        this.action = SalaryDetailsAction.EDIT;
    }
    
    public void onGenerate() {
        selectedSalary.setDate(LocalDate.now());
        salaryService.save(selectedSalary);
    }
    
    public boolean isNotNewSalary() {
        return selectedSalary.getId() != null;
    }
    
    public Salary getSelectedSalary() {
        return selectedSalary;
    }

    public void setSelectedSalary(Salary selectedSalary) {
        this.selectedSalary = selectedSalary;
    }

    public boolean isCalculateMode() {
        return action.equals(SalaryDetailsAction.CALCULATE);
    }
    
    public boolean isEditMode() {
        return action.equals(SalaryDetailsAction.EDIT);
    }
}

package ua.com.foxminded.serviceacc.controller.salary;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.service.SalaryCalculationDetails;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Named
@ViewScoped
public class SalaryCalculationController implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SalaryCalculationController.class);
    
    private static final long serialVersionUID = 1L;

    private final SalaryService salaryService;
    
    private List<SalaryCalculationDetails> salaryCalculationDetailsList;
    
    private SalaryCalculationDetails selectedSalaryDetails;
    
    @Inject
    public SalaryCalculationController(SalaryService salaryService) {
        super();
        this.salaryService = salaryService;
    }

    @PostConstruct
    public void init() {
        if(!FacesContext.getCurrentInstance().isPostback()) {
            prepareData();
        }
    }
    
    public void prepareData() {
        salaryCalculationDetailsList = salaryService.getSalaryCalculationDetails();
    }

    public List<SalaryCalculationDetails> getSalaryCalculationDetailsList() {
        return salaryCalculationDetailsList;
    }

    public SalaryCalculationDetails getSelectedSalaryDetails() {
        return selectedSalaryDetails;
    }

    public void setSelectedSalaryDetails(SalaryCalculationDetails selectedSalaryDetails) {
        this.selectedSalaryDetails = selectedSalaryDetails;
    }

}

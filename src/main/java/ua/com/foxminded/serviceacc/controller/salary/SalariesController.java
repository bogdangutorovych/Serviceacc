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

import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Named
@ViewScoped
public class SalariesController implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SalariesController.class);
    
    private static final long serialVersionUID = 1L;

    private final SalaryService salaryService;
    
    private List<Salary> salaries;
    
    private Salary selectedSalary;
    
    @Inject
    public SalariesController(SalaryService salaryService) {
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
        salaries = salaryService.findAll();
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

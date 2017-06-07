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

import ua.com.foxminded.serviceacc.controller.JSFUtils;
import ua.com.foxminded.serviceacc.service.SalaryService;
import ua.com.foxminded.serviceacc.service.dto.PrepareSalaryInfo;

@Named
@ViewScoped
public class SalaryCalculationController implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(SalaryCalculationController.class);

    private static final long serialVersionUID = 1L;

    private final SalaryService salaryService;

    private List<PrepareSalaryInfo> prepareSalaryInfoList;

    private PrepareSalaryInfo selectedPrepareSalaryInfo;

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
        prepareSalaryInfoList = salaryService.getPrepareSalaryInfoList();
    }

    public void onSalaryDetailsClose() {
        SalaryDetailsController salaryDetailsController = JSFUtils.getBean(SalaryDetailsController.class);

        if (salaryDetailsController != null) {
            salaryDetailsController.setSelectedSalary(null);
        }

        prepareData();
    }

    public PrepareSalaryInfo getSelectedPrepareSalaryInfo() {
        return selectedPrepareSalaryInfo;
    }

    public void setSelectedPrepareSalaryInfo(PrepareSalaryInfo selectedPrepareSalaryInfo) {
        this.selectedPrepareSalaryInfo = selectedPrepareSalaryInfo;
    }

    public List<PrepareSalaryInfo> getPrepareSalaryInfoList() {
        return prepareSalaryInfoList;
    }

}

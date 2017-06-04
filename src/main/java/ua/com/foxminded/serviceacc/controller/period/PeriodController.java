package ua.com.foxminded.serviceacc.controller.period;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.service.PeriodService;

@Named
@ViewScoped
public class PeriodController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(PeriodController.class);

    private static final long serialVersionUID = 1L;

    private Period selectedPeriod;
    private final PeriodService periodService;

    @Inject
    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    public void add() {
        selectedPeriod = new Period();
    }

    public void onOk() {
        selectedPeriod = periodService.save(selectedPeriod);
    }

    public void clearSelected() {
        selectedPeriod = null;
    }

    public void onCancel() {
        selectedPeriod = null;
    }

    public Period getSelectedPeriod() {
        return selectedPeriod;
    }

    public void setSelectedPeriod(Period selectedPeriod) {
        this.selectedPeriod = selectedPeriod;
    }

}

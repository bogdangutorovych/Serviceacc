package ua.com.foxminded.serviceacc.controller.period;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.service.PeriodService;

@Named
@ViewScoped
@ManagedBean
public class PeriodController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(PeriodController.class);

    private static final long serialVersionUID = 1L;

    private Period selected;
    private PeriodService periodService;

    public PeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    public void add() {
        selected = new Period();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = periodService.create(selected);
        }

        periodService.update(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Period getSelected() {
        return selected;
    }

    public void setSelected(Period selected) {
        this.selected = selected;
    }

    public PeriodService getPeriodService() {
        return periodService;
    }

    public void setPeriodService(PeriodService periodService) {
        this.periodService = periodService;
    }

}

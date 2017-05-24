package ua.com.foxminded.serviceacc.controller.money;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.service.MoneyService;

@Named
@ViewScoped
public class MoneyController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(MoneyController.class);

    private static final long serialVersionUID = 1L;

    private Money selected;
    private MoneyService moneyService;

    @Inject
    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public void add() {
        selected = new Money();
    }

    public void onOk() {
        selected = moneyService.save(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Money getSelected() {
        return selected;
    }

    public void setSelected(Money selected) {
        this.selected = selected;
    }

    public MoneyService getMoneyService() {
        return moneyService;
    }

    public void setMoneyService(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

}

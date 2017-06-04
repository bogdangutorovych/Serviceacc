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

    private Money selectedMoney;
    private final MoneyService moneyService;

    @Inject
    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public void add() {
        selectedMoney = new Money();
    }

    public void onOk() {
        selectedMoney = moneyService.save(selectedMoney);
    }

    public void clearSelected() {
        selectedMoney = null;
    }

    public void onCancel() {
        selectedMoney = null;
    }

    public Money getSelectedMoney() {
        return selectedMoney;
    }

    public void setSelectedMoney(Money selectedMoney) {
        this.selectedMoney = selectedMoney;
    }

}

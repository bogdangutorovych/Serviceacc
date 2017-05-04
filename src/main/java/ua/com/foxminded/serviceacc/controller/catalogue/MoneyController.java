package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.CurrencyType;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.service.CurrencyTypeService;
import ua.com.foxminded.serviceacc.service.MoneyService;

@Controller
@ManagedBean
@ViewScoped
public class MoneyController implements Serializable {

    private static final long serialVersionUID = 1L;

    private Money selected;

    private List<Money> list;
    private MoneyService moneyService;

    private List<CurrencyType> availableCurrencyType;
    private CurrencyTypeService currencyTypeService;

    @Autowired
    public MoneyController(MoneyService moneyService, CurrencyTypeService currencyTypeService) {
        this.moneyService = moneyService;
        this.currencyTypeService = currencyTypeService;
    }

    @PostConstruct
    public void init() {
        list = moneyService.findAll();
    }

    public void add() {
        selected = new Money();
        list.add(selected);
    }

    public void delete() {
        list.remove(selected);
        moneyService.delete(selected.getId());
        selected = null;
    }

    public Money getSelected() {
        return selected;
    }

    public void setSelected(Money selected) {
        this.selected = selected;
    }

    public List<Money> getList() {
        return list;
    }

    public void setList(List<Money> list) {
        this.list = list;
    }

    public MoneyService getMoneyService() {
        return moneyService;
    }

    public void setMoneyService(MoneyService moneyService) {
        this.moneyService = moneyService;
    }

    public List<CurrencyType> getAvailableCurrencyType() {
        return availableCurrencyType;
    }

    public void setAvailableCurrencyType(List<CurrencyType> availableCurrencyType) {
        this.availableCurrencyType = availableCurrencyType;
    }

    public CurrencyTypeService getCurrencyTypeService() {
        return currencyTypeService;
    }

    public void setCurrencyTypeService(CurrencyTypeService currencyTypeService) {
        this.currencyTypeService = currencyTypeService;
    }

}

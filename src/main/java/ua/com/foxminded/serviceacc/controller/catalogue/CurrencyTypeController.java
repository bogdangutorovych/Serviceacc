package ua.com.foxminded.serviceacc.controller.catalogue;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.CurrencyType;
import ua.com.foxminded.serviceacc.service.CurrencyTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Controller
@ManagedBean
@ViewScoped
public class CurrencyTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private CurrencyType selected;

    private static List<CurrencyType> currencyList;

    private CurrencyTypeService currencyService;
    
    @Autowired
    public CurrencyTypeController(CurrencyTypeService currencyService) {
        this.currencyService = currencyService;
    }

    @PostConstruct
    public void init() {
//    	currencyList = currencyService.findAll();
    	currencyList = new ArrayList(Currency.getAvailableCurrencies());
    }

    public CurrencyTypeService getCurrensyService() {
        return currencyService;
    }

    public List<CurrencyType> getCurrencyList() {
        return currencyList;
    }

    public CurrencyType getSelected() {
        return selected;
    }

    public void setSelected(CurrencyType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new CurrencyType("","");
        currencyList.add(selected);
    }

    public void delete() {
    	currencyList.remove(selected);
        currencyService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        currencyService.save((CurrencyType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
    	CurrencyType currency = (CurrencyType) event.getObject();
        if (currency.getId() == null) {
        	currencyList.remove(currency);
        }
    }

}
package ua.com.foxminded.serviceacc.controller.deal;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@ViewScoped
@ManagedBean
public class DealController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(DealController.class);

    private static final long serialVersionUID = 1L;

    private Deal selected;
    private DealService dealService;
    private Money price;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostConstruct
    public void init() {
        selected = new Deal();

    }

    public void add(Client client) {
        selected = new Deal();
        price = new Money();
        selected.setClient(client);
        selected.setService(new Service());
    }

    public String showDefaultServiceNameValue() {
        if (selected.getService().getName() == null) {
            return "Выберите услугу";
        }
        return selected.getService().getName();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected.getService().getPrices().add(price);
            dealService.save(selected);
        }
        dealService.save(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Deal getSelected() {
        return selected;
    }

    public void setSelected(Deal selected) {
        this.selected = selected;
    }

    public DealService getDealService() {
        return dealService;
    }

    public void setDealService(DealService dealService) {
        this.dealService = dealService;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

}

package ua.com.foxminded.serviceacc.controller.deal;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
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
public class DealController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(DealController.class);

    private static final long serialVersionUID = 1L;

    private Deal selected;
    private DealService dealService;
    private Money price;

    @Inject
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostConstruct
    public void init() {

    }

    public void add(Client client) {
        selected = new Deal();
        price = new Money();
        selected.setClient(client);
        selected.setService(new Service());
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

    public void delete(Deal deal) {
        dealService.delete(deal.getId());
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

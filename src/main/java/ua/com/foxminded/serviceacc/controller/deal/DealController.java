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

    private Deal selectedDeal;
    private final DealService dealService;
    private Money price;

    @Inject
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    public void add(Client client) {
        selectedDeal = new Deal();
        price = new Money();
        selectedDeal.setClient(client);
        selectedDeal.setService(new Service());
    }

    public void onOk() {
        if (selectedDeal.getId() == null) {
            selectedDeal.getService().getPrices().add(price);
            dealService.save(selectedDeal);
        }
        dealService.save(selectedDeal);
    }

    public void clearSelected() {
        selectedDeal = null;
    }

    public void delete(Deal deal) {
        dealService.delete(deal.getId());
    }

    public void onCancel() {
        selectedDeal = null;
    }

    public Deal getSelectedDeal() {
        return selectedDeal;
    }

    public void setSelectedDeal(Deal selectedDeal) {
        this.selectedDeal = selectedDeal;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

}

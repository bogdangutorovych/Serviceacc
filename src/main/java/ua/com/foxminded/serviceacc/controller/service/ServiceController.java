package ua.com.foxminded.serviceacc.controller.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Named
@ViewScoped
public class ServiceController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    private final ServiceService serviceService;

    private Service selectedService;
    private List<Money> tempPrices;
    private Money newMoney;

    @Inject
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
        tempPrices = new ArrayList<>();
        newMoney = new Money();
    }

    public void addNewService() {
        selectedService = new Service();
        selectedService.setPrices(new HashSet<>());
        selectedService.setManagerRate(new Money());
        tempPrices.clear();
    }

    public void onEdit() {
        if (selectedService != null) {
            tempPrices.clear();
            tempPrices.addAll(selectedService.getPrices());
            prepareNewMoney();
        }
    }

    public void onOk() {
        selectedService.getPrices().clear();
        selectedService.getPrices().addAll(tempPrices);
        serviceService.save(selectedService);
        tempPrices.clear();
        log.debug("onOk save Service: " + selectedService);
    }

    public void addPrice() {
        if (newMoney != null) {
            tempPrices.add(newMoney);
        }
    }

    public List<Money> convertMoneyListFromSet(Set<Money> moneySet) {
        if (moneySet != null) {
            return new ArrayList<Money>(moneySet);
        } else {
            return null;
        }
    }

    public void removePrice(Money price) {
        tempPrices.remove(price);
    }

    public void prepareNewMoney() {
        newMoney = new Money();
    }

    public List<Money> getTempPrices() {
        return tempPrices;
    }

    public Currency[] getCurrencyTypes() {
        return Currency.values();
    }

    public Money getNewMoney() {
        return newMoney;
    }

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }
}

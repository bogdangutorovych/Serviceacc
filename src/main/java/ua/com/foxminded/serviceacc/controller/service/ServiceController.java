package ua.com.foxminded.serviceacc.controller.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.service.ServiceService;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Named
@ViewScoped
@ManagedBean
public class ServiceController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    private final ServiceService serviceService;

    private Service selectedService;
    private List<Money> tempPrices = new ArrayList<>();
    private Money newMoney = new Money();

    @Inject
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
    }

    public void addNewService(){
        selectedService = new Service();
        tempPrices.clear();
    }

    public void onEdit(){
        if (selectedService != null){
            tempPrices.clear();
            tempPrices.addAll(selectedService.getPrices());
            prepareNewMoney();
        }
    }

    public void onOk(){
        selectedService.getPrices().clear();
        selectedService.getPrices().addAll(tempPrices);
        serviceService.save(selectedService);
        tempPrices.clear();
        log.debug("onOk save Service: " + selectedService);
    }

    public void addPrice(){
        if (newMoney != null){
            tempPrices.add(newMoney);
        }
    }

    public List<Money> convertMoneyListFromSet(Set<Money> moneySet){
        if (moneySet != null){
            return new ArrayList<Money>(moneySet);
        }else{
            return null;
        }
    }

    public void removePrice(Money price){
        tempPrices.remove(price);
    }

    public void prepareNewMoney(){
        newMoney = new Money();
    }

    //Getters and Setters

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    public List<Money> getTempPrices() {
        return tempPrices;
    }

    public Currency[] getCurrencyTypes(){
        return Currency.values();
    }

    public Money getNewMoney() {
        return newMoney;
    }

}

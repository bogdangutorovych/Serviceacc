package ua.com.foxminded.serviceacc.controller.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ServiceService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;

@Controller
@ViewScoped
@ManagedBean
public class ServiceController implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private ServiceService serviceService;

    private Service selectedService;
    private static List<Service> serviceList;
    private List<Money> prices = new ArrayList<>();
    private Money newMoney = new Money();
    private List<Currency> currencyList = new ArrayList<>();

    public List<Service> getServiceList(){
        return serviceList;
    }

    public Service getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(Service selectedService) {
        this.selectedService = selectedService;
    }

    @PostConstruct
    public void init() {
        serviceList = serviceService.findAll();
        currencyList.add(Currency.getInstance("UAH"));
        currencyList.add(Currency.getInstance("USD"));
    }

    public void addNewService(){
        selectedService = new Service();
        prices.clear();
    }

    public void deleteService(){
        serviceService.delete(selectedService.getId());
        serviceList.remove(selectedService);
        log.debug("Delete Service: " + selectedService);
        selectedService = null;
    }

    public void onOk(){
        if (selectedService.getId() == null) {
            selectedService.getPrices().addAll(prices);
            selectedService = serviceService.save(selectedService);
            serviceList.add(selectedService);
            log.debug("Save new Service: " + selectedService);
        }else{
            selectedService.getPrices().clear();
            selectedService.getPrices().addAll(prices);
            int index = serviceList.indexOf(selectedService);
            selectedService = serviceService.update(selectedService);
            serviceList.set(index, selectedService);
            log.debug("Update Service: " + selectedService);
        }
        log.debug("List: " + serviceList);
    }

    public void addPrice(){
        if (newMoney != null){
            prices.add(newMoney);
        }

    }

    public void onEdit(){
        if (selectedService != null){
            prices.clear();
            prices.addAll(selectedService.getPrices());
            prepareNewMoney();
        }

    }

    public List<Money> getPrices() {
        return prices;
    }

    public List<Currency> getCurrencyList(){
        return currencyList;
    }

    public void prepareNewMoney(){

        newMoney = new Money();
        newMoney.setCurrency(Currency.getInstance("UAH"));

    }

    public Money getNewMoney() {
        return newMoney;
    }

    public List<Money> getMoneyList(Set<Money> moneySet){
        List<Money> tempPrices = null;
        if (moneySet != null){
            tempPrices = new ArrayList<Money>(moneySet);
        }
        return tempPrices;
    }

    public void removePrice(Money price){
        prices.remove(price);
    }
}

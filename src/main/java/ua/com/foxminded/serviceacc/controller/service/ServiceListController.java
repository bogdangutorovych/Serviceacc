package ua.com.foxminded.serviceacc.controller.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.service.ServiceService;

/**
 * Created by andreb on 17.05.17.
 */
@Named
@ViewScoped
@ManagedBean
public class ServiceListController implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ServiceListController.class);

    private final ServiceService serviceService;
    private List<Service> serviceList;

    @Inject
    public ServiceListController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
        log.debug("Create ServiceList Bean");
        serviceList = serviceService.findAll();
        updateServiceListFromDB();
    }

    public void deleteService(Service service) {
        serviceService.delete(service.getId());
        updateServiceListFromDB();
        log.debug("Delete Service: " + service);
    }

    public void updateServiceListFromDB() {
        log.debug("update ServiceList from DB: " + serviceList);
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public Currency[] getCurrencyTypes() {
        return Currency.values();
    }

}

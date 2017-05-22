package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Named
@ViewScoped
@ManagedBean
public class ContractController implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(ContractController.class);
    private static final long serialVersionUID = 1L;

    private Contract selected;

    private List<Client> availableClients;
    private List<Manager> availableManagers;
    private List<Service> availableServices;

    private ContractService contractService;
    private ClientService clientService;
    private ManagerService managerService;
    private ServiceService serviceService;

    @Inject
    public ContractController(ContractService contractService, ClientService clientService,
            ManagerService managerService, ServiceService serviceService) {
        this.contractService = contractService;
        this.clientService = clientService;
        this.managerService = managerService;
        this.serviceService = serviceService;
    }

    @PostConstruct
    public void init() {
    }

    public void addFromDeal(Deal deal) {
        selected = new Contract();
        selected.setDeal(deal);
        getActualLists();
    }

    public void getActualLists() {
        availableClients = clientService.findAll();
        availableManagers = managerService.findAll();
        availableServices = serviceService.findAll();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = contractService.save(selected);
            selected.setNumber("contr# " + selected.getId());
        }
        contractService.save(selected);
    }

    public void onCancel() {
        logger.info("onCancel");
        selected = null;
    }

    public void delete() {
        contractService.delete(selected.getId());
        selected = null;
    }

    public Contract getSelected() {
        return selected;
    }

    public void setSelected(Contract selected) {
        this.selected = selected;
    }

    public List<Client> getAvailableClients() {
        return availableClients;
    }

    public void setAvailableClients(List<Client> availableClients) {
        this.availableClients = availableClients;
    }

    public List<Manager> getAvailableManagers() {
        return availableManagers;
    }

    public void setAvailableManagers(List<Manager> availableManagers) {
        this.availableManagers = availableManagers;
    }

    public List<Service> getAvailableServices() {
        return availableServices;
    }

    public void setAvailableServices(List<Service> availableServices) {
        this.availableServices = availableServices;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

}

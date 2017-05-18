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

    private Contract selectedContract;
    private List<Contract> list;

    private List<Client> availableClients;
    private List<Manager> availableManagers;
    private List<Service> availableServices;

    private ContractService contractService;

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

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
        list = contractService.findAll();
    }

    public void add() {
        selectedContract = new Contract();
        selectedContract.setDeal(new Deal());
        getActualLists();
    }

    public void getActualLists() {
        availableClients = clientService.findAll();
        availableManagers = managerService.findAll();
        availableServices = serviceService.findAll();
    }

    public void onOk() {
        if (selectedContract.getId() == null) {
            selectedContract = contractService.create(selectedContract);
            selectedContract.setNumber("" + selectedContract.getId());
        }

        contractService.update(selectedContract);
        init();

    }

    public void delete() {
        list.remove(selectedContract);
        contractService.delete(selectedContract.getId());
        selectedContract = null;
    }

    public void onCancel() {
        logger.info("onCancel");
        selectedContract = null;
    }

    public Contract getSelectedContract() {
        return selectedContract;
    }

    public void setSelectedContract(Contract selectedContract) {
        this.selectedContract = selectedContract;
    }

    public List<Contract> getList() {
        return list;
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

}

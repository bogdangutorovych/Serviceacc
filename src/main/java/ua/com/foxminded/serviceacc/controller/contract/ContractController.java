package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.ContractStatus;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.ContractStatusService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Controller
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
    private List<ContractStatus> availableStatuses;

    private ContractService contractService;
    private ClientService clientService;
    private ManagerService managerService;
    private ServiceService serviceService;
    private ContractStatusService contractStatusService;

    @Autowired
    public ContractController(ContractService contractService, ClientService clientService,
            ManagerService managerService, ServiceService serviceService, ContractStatusService contractStatusService) {
        this.contractService = contractService;
        this.clientService = clientService;
        this.managerService = managerService;
        this.serviceService = serviceService;
        this.contractStatusService = contractStatusService;
    }

    @PostConstruct
    public void init() {
        list = contractService.findAll();
    }

    public void add() {
        selectedContract = new Contract();
        getActualLists();
    }

    public void getActualLists() {
        availableClients = clientService.findAll();
        availableManagers = managerService.findAll();
        availableServices = serviceService.findAll();
        availableStatuses = contractStatusService.findAll();
    }

    public void onOk() {
        if (selectedContract.getId() == null) {
            selectedContract = contractService.create(selectedContract);
            selectedContract.setNumber("" + selectedContract.getId());
            ContractStatus defaultСontractStatus = contractStatusService.findByStatusTitle("В ожидании");
            selectedContract.setContractStatus(defaultСontractStatus);
        } else {
            Contract currentContract = contractService.findById(selectedContract.getId());
            ContractStatus currentContractStatus = currentContract.getContractStatus();
            ContractStatus selectedContractStatus = selectedContract.getContractStatus();
            if (!currentContractStatus.getTitle().equals(selectedContractStatus.getTitle())) {
                switch (selectedContractStatus.getTitle()) {
                case "В ожидании":

                    break;

                case "Активировать":
                    if (selectedContract.getPaymentDate() == null) {
                        selectedContract.setPaymentDate(LocalDate.now().plusMonths(1));
                    }
                    break;

                case "Заморожен":
                    selectedContract.setCloseDate(LocalDate.now());
                    selectedContract.setManager(null);
                    break;

                case "Завершен":
                    selectedContract.setCloseDate(LocalDate.now());
                    selectedContract.setManager(null);
                    break;

                default:
                    break;
                }
            }
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

    public List<ContractStatus> getAvailableStatuses() {
        return availableStatuses;
    }

    public void setAvailableStatuses(List<ContractStatus> availableStatuses) {
        this.availableStatuses = availableStatuses;
    }

}

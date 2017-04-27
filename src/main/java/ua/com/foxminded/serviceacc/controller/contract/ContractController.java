package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.LocalDateAttributeConverter;
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

	private Client availableClient;
	private List<Client> availableClients = new ArrayList<>();

	// private Money clientRate;
	// private Long clientRateAmount;
	// private List<Money> clientRates;

	private Manager availableManager;
	private List<Manager> availableManagers = new ArrayList<>();

	// private Money managerRate;
	// private List<Money> managerRates;

	private Service availableService;
	private List<Service> availableServices = new ArrayList<>();

	private ContractService contractService;
	private ClientService clientService;
	private ManagerService managerService;
	private ServiceService serviceService;
	// private MoneyService moneyService;

	private Date utilDate;

	@Autowired
	public ContractController(ContractService contractService, ClientService clientService,
			ManagerService managerService, ServiceService serviceService) {
		this.contractService = contractService;
		this.clientService = clientService;
		this.managerService = managerService;
		this.serviceService = serviceService;
	}

	@PostConstruct
	public void init() {
		utilDate = new Date();
		list = contractService.findAll();
		availableClients = clientService.findAll();
		availableManagers = managerService.findAll();
		// availableServices = serviceService.findAll();
	}

	public void add() {
		selectedContract = new Contract();
	}

	public void delete() {
		list.remove(selectedContract);
		contractService.delete(selectedContract.getId());
		selectedContract = null;
	}

	public void onOk() {
		if (selectedContract.getId() == null) {
			selectedContract.setDate(new LocalDateAttributeConverter().convertToEntityAttribute(utilDate));
			selectedContract.setClient(availableClient);
			selectedContract.setManager(availableManager);
			selectedContract = contractService.create(selectedContract);
			selectedContract.setNumber("Contract # " + selectedContract.getId());

		}

		list.add(contractService.update(selectedContract));

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

	public Client getAvailableClient() {
		return availableClient;
	}

	public void setAvailableClient(Client availableClient) {
		this.availableClient = availableClient;
	}

	public Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(Date utilDate) {
		this.utilDate = utilDate;
	}

	public Manager getAvailableManager() {
		return availableManager;
	}

	public void setAvailableManager(Manager availableManager) {
		this.availableManager = availableManager;
	}

	public List<Manager> getAvailableManagers() {
		return availableManagers;
	}

	public void setAvailableManagers(List<Manager> availableManagers) {
		this.availableManagers = availableManagers;
	}

	public Service getAvailableService() {
		return availableService;
	}

	public void setAvailableService(Service availableService) {
		this.availableService = availableService;
	}

	public List<Service> getAvailableServices() {
		return availableServices;
	}

	public void setAvailableServices(List<Service> availableServices) {
		this.availableServices = availableServices;
	}

	public void setAvailableClients(List<Client> availableClients) {
		this.availableClients = availableClients;
	}

}

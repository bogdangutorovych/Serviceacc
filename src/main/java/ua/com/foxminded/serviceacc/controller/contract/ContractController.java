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
import ua.com.foxminded.serviceacc.model.ContractStatus;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Service;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.ContractStatusService;
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

	private ContractStatus contractStatus;
	private List<ContractStatus> availableStatuses = new ArrayList<>();

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
	private ContractStatusService contractStatusService;
	// private MoneyService moneyService;

	private Date contractUtilDate;
	private Date paymentUtilDate;
	private Date closeUtilDate;

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
		utilDateInit();
		list = contractService.findAll();
		availableClients = clientService.findAll();
		availableManagers = managerService.findAll();
		availableServices = serviceService.findAll();
		availableStatuses = contractStatusService.findAll();
	}

	private void utilDateInit() {
		contractUtilDate = new Date();
		paymentUtilDate = new Date();
		closeUtilDate = new Date();
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
			selectedContract
					.setContractDate(new LocalDateAttributeConverter().convertToEntityAttribute(contractUtilDate));
			selectedContract.setClient(availableClient);
			selectedContract.setManager(availableManager);
			selectedContract.setService(availableService);
			// contractStatus = new ContractStatus("PND", "Pending");
			contractStatus = contractStatusService.findByStatusTitle("Pending");
			selectedContract.setContractStatus(contractStatus);
			selectedContract = contractService.create(selectedContract);
			selectedContract.setNumber("Contract # " + selectedContract.getId());

		}

		list.add(contractService.update(selectedContract));

	}

	public void edit() {
		contractStatus = getContractStatus();
		availableManager = getAvailableManager();
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
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

	public Date getContractUtilDate() {
		return contractUtilDate;
	}

	public void setContractUtilDate(Date contractUtilDate) {
		this.contractUtilDate = contractUtilDate;
	}

	public Date getPaymentUtilDate() {
		return paymentUtilDate;
	}

	public void setPaymentUtilDate(Date paymentUtilDate) {
		this.paymentUtilDate = paymentUtilDate;
	}

	public Date getCloseUtilDate() {
		return closeUtilDate;
	}

	public void setCloseUtilDate(Date closeUtilDate) {
		this.closeUtilDate = closeUtilDate;
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

	public List<ContractStatus> getAvailableStatuses() {
		return availableStatuses;
	}

	public void setAvailableStatuses(List<ContractStatus> availableStatuses) {
		this.availableStatuses = availableStatuses;
	}

}

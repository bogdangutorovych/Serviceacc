package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.util.ArrayList;
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

	private List<Client> availableClients = new ArrayList<>();
	private List<Manager> availableManagers = new ArrayList<>();
	private List<Service> availableServices = new ArrayList<>();
	private List<ContractStatus> availableStatuses = new ArrayList<>();

	private ContractService contractService;
	private ClientService clientService;
	private ManagerService managerService;
	private ServiceService serviceService;
	private ContractStatusService contractStatusService;
	// private MoneyService moneyService;

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
			selectedContract.setNumber("Договор № " + selectedContract.getId());

			contractService.update(selectedContract);
			list.add(selectedContract);
			System.out.println(
					selectedContract.getManager().getFirstName() + " " + selectedContract.getManager().getLastName());
		}

		// list.add(contractService.update(selectedContract));

		Contract updated = contractService.update(selectedContract);
		int elementNumber = list.indexOf(selectedContract);
		list.set(elementNumber, updated);
		selectedContract = updated;
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

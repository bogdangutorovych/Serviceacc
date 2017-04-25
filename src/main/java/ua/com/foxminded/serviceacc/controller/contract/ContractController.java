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
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ContractService;

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
	// private List<Manager> availableManager;
	// private List<Service> availableService;

	private ContractService contractService;
	private ClientService clientService;

	@Autowired
	public ContractController(ContractService contractService, ClientService clientService) {
		this.contractService = contractService;
		this.clientService = clientService;
	}

	@PostConstruct
	public void init() {
		list = contractService.findAll();
		availableClients = clientService.findAll();
	}

	public void add() {
		selectedContract = new Contract();
		// list.add(selectedContract);
	}

	public void delete() {
		list.remove(selectedContract);
		contractService.delete(selectedContract.getId());
		selectedContract = null;
	}

	public void onOk() {
		if (selectedContract.getId() == null) {
			list.add(selectedContract);
		}

		contractService.update(selectedContract);
	}

	public void onCancel() {
		logger.info("onCancel");
		// logger.info("tempSet" + tempInfosSet);
		// logger.info("clientSet" + selectedClient.getInformations());
		// tempInfosSet.clear();
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

}

package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Controller
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client selectedClient;

	private static List<Client> list;

	private List<ClientStatusType> availableStatuses;
	private List<ClientLevelType> availableLevels;

	private final ClientService clientService;
	private final ClientStatusTypeService cstService;
	private final ClientLevelTypeService cltService;

	@Autowired
	public ClientController(ClientService clientService, ClientStatusTypeService cstService,
			ClientLevelTypeService cltService) {
		this.clientService = clientService;
		this.cstService = cstService;
		this.cltService = cltService;
	}

	@PostConstruct
	public void init() {
		list = clientService.findAllByFetch();
	}

	public void add() {
		selectedClient = new Client();
		getActualLists();
	}

	public void getActualLists() {
		availableStatuses = cstService.findAll();
		availableLevels = cltService.findAll();
	}

	public void onOk() {
		if (selectedClient.getId() == null) {
			list.add(selectedClient);
		}

		clientService.update(selectedClient);
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public Client getSelectedClient() {
		return selectedClient;

	}

	public List<Client> getList() {
		return list;
	}

	public void delete() {
		list.remove(selectedClient);
		clientService.delete(selectedClient.getId());
		selectedClient = null;
	}

	public List<ClientStatusType> getAvailableStatuses() {
		return availableStatuses;
	}

	public List<ClientLevelType> getAvailableLevels() {
		return availableLevels;
	}
}

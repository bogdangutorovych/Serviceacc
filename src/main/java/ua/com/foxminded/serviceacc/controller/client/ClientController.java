package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Controller
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	private static final long serialVersionUID = 1L;

	private Client selectedClient;
	private static List<Client> list;
	private List<ClientInformation> tempList = new ArrayList<>();

	private List<ClientStatusType> availableStatuses;
	private List<ClientLevelType> availableLevels;

	private final ClientService clientService;
	private final ClientStatusTypeService cstService;
	private final ClientLevelTypeService cltService;
	private final ClientInformationTypeService citService;

	@Autowired
	public ClientController(ClientService clientService, ClientStatusTypeService cstService,
			ClientLevelTypeService cltService, ClientInformationTypeService citService) {
		this.clientService = clientService;
		this.cstService = cstService;
		this.cltService = cltService;
		this.citService = citService;
	}

	@PostConstruct
	public void init() {
		list = clientService.findAll();
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

		// Check for empty ClientInformation objects. We don't want to save
		// empty ClientInformation objects
		Iterator<ClientInformation> iteratorInfos = selectedClient.getInformations().iterator();
		while (iteratorInfos.hasNext()) {
			if (iteratorInfos.next().getContent().isEmpty()) {
				iteratorInfos.remove();
			}
		}
		log.info("Infos for save: " + selectedClient.getInformations());
		// Update client and get updated Client object
		Client fetched = clientService.update(selectedClient);
		// Replace client from list by updated client
		int i = list.indexOf(selectedClient);
		list.set(i, fetched);

	}

	/*
	 * Find ClientInformationType from selectedClient by InformationType Needs
	 * for render ClientInformation collection section
	 */
	public ClientInformation getInfoByType(ClientInformationType type) {
		ClientInformation info = null;
		if (selectedClient != null) {
			tempList.clear();
			tempList.addAll(selectedClient.getInformations());
			for (ClientInformation i : tempList) {
				if (i.getClientInformationType().equals(type)) {
					return i;
				}
			}
		} else {
			return null; // selectedClient = null ???
		}
		if (info == null) {
			info = new ClientInformation();
			info.setClientInformationType(type);
			info.setActive(true);
			selectedClient.getInformations().add(info);
		}
		return info;
	}

	public void delete() {
		list.remove(selectedClient);
		clientService.delete(selectedClient.getId());
		selectedClient = null;
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

	public List<ClientStatusType> getAvailableStatuses() {
		return availableStatuses;
	}

	public List<ClientLevelType> getAvailableLevels() {
		return availableLevels;
	}

	public List<ClientInformationType> getInformationTypeList() {
		return citService.findAll();
	}

}

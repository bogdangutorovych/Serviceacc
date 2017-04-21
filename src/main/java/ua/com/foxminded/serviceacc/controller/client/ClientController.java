package ua.com.foxminded.serviceacc.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.*;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(ClientController.class);

	private static final long serialVersionUID = 1L;

	private Client selectedClient;
	Set<ClientInformation> tempInfosSet = new HashSet<>();
	private ClientInformation tempInfo = new ClientInformation();

	private static List<Client> list;

	private List<ClientStatusType> availableStatuses;
	private List<ClientLevelType> availableLevels;
	private List<ClientInformationType> availableInfoTypes;

	private final ClientService clientService;
	private final ClientStatusTypeService cstService;
	private final ClientLevelTypeService cltService;
	@Autowired
	private ClientInformationTypeService informationTypeService;

	@Autowired
	public ClientController(ClientService clientService, ClientStatusTypeService cstService, ClientLevelTypeService cltService) {
		this.clientService = clientService;
		this.cstService = cstService;
		this.cltService = cltService;
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
		availableInfoTypes = informationTypeService.findAll();
	}

	public void onOk() {
		logger.info("onOk");
		if(selectedClient.getId() == null) {
			list.add(selectedClient);
		}
		clientService.update(selectedClient);
		tempInfosSet.clear();
	}

	public void onCancel() {
		logger.info("onCancel");
		selectedClient.getInformations().addAll(tempInfosSet);
		tempInfosSet.clear();
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

	public void deleteInformation(ClientInformation info) {
		tempInfosSet.addAll(selectedClient.getInformations());
		selectedClient.getInformations().remove(info);
	}

	public void addInformation(){
		logger.info("addInfo:" + tempInfo);
		tempInfo.setActive(true);
		tempInfo.setId(0L);
		logger.info("addInfo selectedClient: " + selectedClient);
		selectedClient.getInformations().add(tempInfo);
//		tempInfo.setContent("");
//		tempInfo.setClientInformationType(null);
	}

	public List<ClientStatusType> getAvailableStatuses() {
		return availableStatuses;
	}

	public List<ClientLevelType> getAvailableLevels() {
		return availableLevels;
	}

	public List<ClientInformationType> getAvailableInfoTypes() {
		return availableInfoTypes;
	}

	public ClientInformation getTempInfo() {
		return tempInfo;
	}

	public void setTempInfo(ClientInformation tempInfo) {
		this.tempInfo = tempInfo;
	}
}

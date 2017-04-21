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
		logger.info("getActualList");
		availableStatuses = cstService.findAll();
		availableLevels = cltService.findAll();
		availableInfoTypes = informationTypeService.findAll();
		logger.info("Client: " + selectedClient.getId());
		logger.info("getAL: " + selectedClient.getInformations());
		logger.info("tempSet: " + tempInfosSet);
		tempInfosSet.addAll(selectedClient.getInformations());
        logger.info("tempSet: " + tempInfosSet);
	}

	public void onOk() {
		logger.info("onOk");
		if(selectedClient.getId() == null) {
			list.add(selectedClient);
		}
		logger.info("tempSet" + tempInfosSet);
		logger.info("clientSet" + selectedClient.getInformations());
		selectedClient.getInformations().clear();
		selectedClient.getInformations().addAll(tempInfosSet);
		Client cli = clientService.update(selectedClient);
		logger.info("tempSet" + tempInfosSet);
		logger.info("clientSet" + cli.getInformations());
		tempInfosSet.clear();
	}

	public void onCancel() {
		logger.info("onCancel");
		logger.info("tempSet" + tempInfosSet);
		logger.info("clientSet" + selectedClient.getInformations());
		tempInfosSet.clear();
		tempInfo.setContent("");
		tempInfo.setClientInformationType(null);
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
		logger.info("Remove Info");
		logger.info("tempSet" + tempInfosSet);
		logger.info("clientSet" + selectedClient.getInformations());
		logger.info("info for remove: " + info);
		tempInfosSet.remove(info);
	}

	public void addInformation(){
		logger.info("addInfo:" + tempInfo);
		tempInfo.setActive(true);
		tempInfo.setId(0L);
		logger.info("addInfo selectedClient: " + selectedClient);
		tempInfosSet.add(tempInfo);
		logger.info("tempSet" + tempInfosSet);
		logger.info("clientSet" + selectedClient.getInformations());

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

	public Set<ClientInformation> getTempInfosSet() {
		return tempInfosSet;
	}

	public void setTempInfosSet(Set<ClientInformation> tempInfosSet) {
		this.tempInfosSet = tempInfosSet;
	}
}

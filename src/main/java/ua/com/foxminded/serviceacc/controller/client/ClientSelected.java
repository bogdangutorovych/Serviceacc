package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

@Controller
public class ClientSelected {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientController clientController;

	@Autowired
	private ClientUpdate clientUpdate;

	private Client selectedClient;

	private boolean isShowSelectedClientForm;

	public void hide() {
		clientUpdate.hide();
		setIsShowSelectedClientForm(false);
	}

	public void show() {
		clientUpdate.hide();
		setIsShowSelectedClientForm(true);
	}

	public void selectedFormOnOk() {
		hide();
	}

	public void selectedFormOnDelete() {
		clientService.delete(selectedClient.getId());
		clientController.allClientsUpdate();
		hide();
	}

	public void selectedFormOnUpdate() {
		hide();
		clientController.blockTable();
		clientUpdate.init(this);
		clientUpdate.show();
		clientController.allClientsUpdate();
	}

	public void selectedFormOnUpdateComplete() {
		clientController.unBlockTable();
		clientController.allClientsUpdate();
		clientUpdate.hide();
		selectedClient = null;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public boolean getIsShowSelectedClientForm() {
		return isShowSelectedClientForm;
	}

	public void setIsShowSelectedClientForm(boolean isShowSelectedClientForm) {
		this.isShowSelectedClientForm = isShowSelectedClientForm;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}
}

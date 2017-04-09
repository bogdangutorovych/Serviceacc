package ua.com.foxminded.serviceacc.controller.menu;

import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Named
public class Menu {

	@Inject
	private ClientController clientController;

	@Inject
	private ClientStatusTypeController clientStatusTypeController;

	public void menuOnMain() {
		clientController.hideAllClient();
	}

	public void menuOnAddComplete() {		
		clientController.allClientsUpdate();
	}

	 public void menuOnAll() {
	 clientController.showAllClient();
	 }

	public ClientController getClientsAll() {
		return clientController;
	}

	public void setClientsAll(ClientController clientController) {
		this.clientController = clientController;
	}

	public ClientStatusTypeController getStatusAll() {
		return clientStatusTypeController;
	}

	public void setStatusAll(ClientStatusTypeController clientStatusTypeController) {
		this.clientStatusTypeController = clientStatusTypeController;
	}
}

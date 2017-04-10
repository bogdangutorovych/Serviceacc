package ua.com.foxminded.serviceacc.controller.menu;

import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Named
public class Menu {

	public ClientController getClientController() {
		return clientController;
	}


	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}


	public ClientStatusTypeController getClientStatusTypeController() {
		return clientStatusTypeController;
	}


	public void setClientStatusTypeController(ClientStatusTypeController clientStatusTypeController) {
		this.clientStatusTypeController = clientStatusTypeController;
	}


	@Inject
	private ClientController clientController;

	@Inject
	private ClientStatusTypeController clientStatusTypeController;

	public void menuOnMain() {
		System.out.println("menuOnMain");
		clientController.hideAllClient();
	}
	

	public void menuOnAll() {
		System.out.println("menuOnAll");		
		clientController.showAllClient();
	}

}

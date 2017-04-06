package ua.com.foxminded.serviceacc.controller.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Controller
public class Menu {

	@Autowired
	private ClientController clientController;

	public void menuOnAdd() {
		clientController.blockTable();
		clientController.showNewClientForm();

	}

	public void menuOnAddComplete() {
		clientController.unBlockTable();
		clientController.allClientsUpdate();
		clientController.hideNewClientForm();

	}

	// public void menuOnAll() {
	// clientController.showAllClient();
	// }

	public ClientController getClientsAll() {
		return clientController;
	}

	public void setClientsAll(ClientController clientController) {
		this.clientController = clientController;
	}

}

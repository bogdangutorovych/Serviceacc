package ua.com.foxminded.serviceacc.controller.menu;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Named
@Getter @Setter
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

}

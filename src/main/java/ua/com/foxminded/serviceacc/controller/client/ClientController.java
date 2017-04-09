package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;

@Named
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClientList clientList;

	@Inject
	ClientStatusTypeController clientStatusTypeController;

	public void allClientsUpdate() {
		clientList.updateData();
	}

	public void onRowSelect() {
	
	}

	public void menuOnMain() {
		clientList.hide();
	}

	public void blockTable() {
		clientList.block();
	}

	public void unBlockTable() {
		clientList.unBlock();
	}

	public void showAllClient() {
		clientList.show();
		clientStatusTypeController.hideForm();
	}

	public void hideAllClient() {
		clientList.hide();
	}

	

}

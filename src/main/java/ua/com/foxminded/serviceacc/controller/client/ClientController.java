package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;


@Named
@Getter @Setter
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

	
	public void showAllClient() {
		clientList.show();
		clientStatusTypeController.hideForm();
	}

	public void hideAllClient() {
		clientList.hide();
	}

	

}

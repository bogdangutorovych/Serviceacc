package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;


@Named
@Getter @Setter
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ClientList clientList;

	@Inject
	private ClientCru clientCru;	

	public void allClientsUpdate() {
		clientList.updateData();
	}

	public void onRowSelect() {
		System.out.println("onRowSelect()");
		clientList.hide();
		clientCru.show();
	}	

	public void showAllClient() {
		System.out.println("showAllClient()");		
		clientList.show();	
	}

	public void hideAllClient() {
		System.out.println("hideAllClient()");
		clientList.hide();
	}	

}

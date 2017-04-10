package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;


@Named
public class ClientController implements Serializable {

	public ClientList getClientList() {
		return clientList;
	}

	public void setClientList(ClientList clientList) {
		this.clientList = clientList;
	}

	public ClientCru getClientCru() {
		return clientCru;
	}

	public void setClientCru(ClientCru clientCru) {
		this.clientCru = clientCru;
	}

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

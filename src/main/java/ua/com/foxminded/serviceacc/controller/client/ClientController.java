package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Component
//@ViewScoped
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientList clientList;

	@Autowired
	private ClientAddNew clientAddNew;

	@Autowired
	private ClientSelected clientSelected;

	public void allClientsUpdate() {
		clientList.updateData();
	}

	public void onRowSelect() {
		clientAddNew.hide();
		clientSelected.show();
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
	}

	public void hideAllClient() {
		clientList.hide();
	}

	public void showNewClientForm() {
		clientSelected.hide();
		clientAddNew.show();
	}

	public void hideNewClientForm() {
		clientAddNew.hide();
	}

	public ClientAddNew getNewClient() {
		return clientAddNew;
	}

	public void setNewClient(ClientAddNew clientAddNew) {
		this.clientAddNew = clientAddNew;
	}

	public ClientSelected getClientSelected() {
		return clientSelected;
	}

	public void setClientSelected(ClientSelected clientSelected) {
		this.clientSelected = clientSelected;
	}

}

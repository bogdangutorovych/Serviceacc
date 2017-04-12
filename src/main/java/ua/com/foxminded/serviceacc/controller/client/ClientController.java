package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import ua.com.foxminded.serviceacc.model.Client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
@ManagedBean
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private boolean panelShowDisable = true;

	@Autowired
	private ClientList clientList;

	@Autowired
	private ClientCru clientCru;

	public void allClientsUpdate() {
		clientList.updateData();
	}

	public void onRowSelect() {
		System.out.println("onRowSelect()");
		clientList.hide();
		clientCru.show();

	}

	public void onAdd() {
		System.out.println("onRowSelect()");
		clientList.hide();
		clientCru.setSelected(new Client());
		clientCru.show();
	}

	public void onDelete() {
		System.out.println("onDelete()");
		clientCru.deleteSelected();
		clientList.updateData();
	}

	public void show() {
		System.out.println("showAllClient()");
		show = true;
		clientList.updateData();
		clientList.show();
		turnOffShow();
	}

	public void hide() {
		System.out.println("hideAllClient()");
		show = false;
		clientCru.hide();
		clientList.hide();
		turnOffShow();
	}

	public void turnOnShow() {
		panelShowDisable = false;
	}

	public void turnOffShow() {
		panelShowDisable = true;
	}

	public boolean isShow() {
		return this.show;
	}

	public boolean isPanelShowDisable() {
		return this.panelShowDisable;
	}

	public ClientList getClientList() {
		return this.clientList;
	}

	public ClientCru getClientCru() {
		return this.clientCru;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void setPanelShowDisable(boolean panelShowDisable) {
		this.panelShowDisable = panelShowDisable;
	}

	public void setClientList(ClientList clientList) {
		this.clientList = clientList;
	}

	public void setClientCru(ClientCru clientCru) {
		this.clientCru = clientCru;
	}
}

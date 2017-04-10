package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.model.Client;

@Named
@Getter @Setter
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;
	
	private boolean panelShowDisable = true;
	
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
	
	public void onAdd() {
		System.out.println("onRowSelect()");
		clientList.hide();
		Client client = new Client();
		clientCru.setSelected(client);
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
		clientList.show();
		turnOffShow();
	}

	public void hide() {
		System.out.println("hideAllClient()");
		show = false;
		clientList.hide();
		turnOffShow();
	}
	
	public void turnOnShow(){
		panelShowDisable = false;
	}
	
	public void turnOffShow(){
		panelShowDisable = true;
	}

}

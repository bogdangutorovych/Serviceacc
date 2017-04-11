package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.com.foxminded.serviceacc.model.Client;

@Component
//@Named
@Getter
@Setter
//@SessionScoped
@Scope("view")
//@ManagedBean(name = "clientController")
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private boolean panelShowDisable = true;

	@Autowired
//	@ManagedProperty(value = "#{clientList}")
	private ClientList clientList;

	@Autowired
//	@ManagedProperty(value = "#{clientCru}")
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
		clientList.hide();
		turnOffShow();
	}

	public void turnOnShow() {
		panelShowDisable = false;
	}

	public void turnOffShow() {
		panelShowDisable = true;
	}

}

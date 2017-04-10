package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Named
@Getter @Setter
public class ClientCru implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private Client selected;	

	@Inject
	private ClientService clientService;

	@Inject
	private ClientController clientController;

	@Inject
	private ClientStatusTypeService clientStatusTypeService;	

	private MenuModel model;

	public void init(Client clientSelected) {		
		selected = new Client();		
		selected.setId(clientSelected.getId());
		selected.setStatus(clientSelected.getStatus());
		createStatusMenu();
	}


	private void createStatusMenu() {
		model = new DefaultMenuModel();
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("choose status");		
		for (ClientStatusType  statusType: clientStatusTypeService.findAll()){
			DefaultMenuItem item = new DefaultMenuItem(statusType.getTitle());			
			firstSubmenu.addElement(item);
		}
		model.addElement(firstSubmenu);
	}		

	public void onOk() {
		hide();
		clientController.showAllClient();
		clientService.update(selected);		
	}

	public void onCancel() {
		hide();
		clientController.showAllClient();

	}

	public void updateFormChangeLevel(String level) {
		// TODO: level
	}

	public void updateFormChangeStatus(String status) {		
		selected.setStatus(clientStatusTypeService.findByStatusName(status));
	}

	public void hide() {
		show = false;
	}

	public void show() {
		show = true;
	}


}
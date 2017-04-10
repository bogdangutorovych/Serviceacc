package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Named
@Getter
@Setter
public class ClientCru implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private Client selected;

	@Inject
	private ClientService clientService;

	@Inject
	private ClientController clientController;

	@Inject
	private ClientStatusTypeService clientStatusTypeService;

	@Inject
	private ClientLevelTypeService clientLevelTypeService;

	private MenuModel status;
	private MenuModel level;

	@PostConstruct
	public void init() {
		createStatusMenu();
		createLevelMenu();
		selected = new Client();

	}

	private void createStatusMenu() {
		status = new DefaultMenuModel();
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("choose status");
		for (ClientStatusType statusType : clientStatusTypeService.findAll()) {
			DefaultMenuItem item = new DefaultMenuItem(statusType.getTitle());
			firstSubmenu.addElement(item);
		}
		status.addElement(firstSubmenu);
	}

	private void createLevelMenu() {
		level = new DefaultMenuModel();
		DefaultSubMenu firstSubmenu = new DefaultSubMenu("choose level");
		for (ClientLevelType levelType : clientLevelTypeService.findAll()) {
			DefaultMenuItem item = new DefaultMenuItem(levelType.getTitle());
			firstSubmenu.addElement(item);
		}
		level.addElement(firstSubmenu);
	}

	public void onOk() {
		if (selected.getId() == null) {
			selected = clientService.create(selected);
		} else {
			clientService.update(selected);
		}
		hide();
	}

	public void onCancel() {
		hide();
		selected = null;
	}

	public void updateFormChangeLevel(String level) {
		// TODO: level
	}

	public void updateFormChangeStatus(String status) {
		selected.setStatus(clientStatusTypeService.findByStatusName(status));
	}

	public void hide() {
		show = false;
		clientController.show();
	}

	public void show() {
		show = true;
	}

	public void deleteSelected() {
		System.out.println("deleteSelected()" + selected.getId());
		clientService.delete(selected.getId());
	}

}
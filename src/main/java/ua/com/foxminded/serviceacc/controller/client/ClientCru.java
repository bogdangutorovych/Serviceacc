package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.faces.model.SelectItem;

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

	private List<SelectItem> statuses;
	private MenuModel level;
	private String statusSelected = "";
	private String levelSelected = "";

	@PostConstruct
	public void init() {
		createStatusMenu();
		createLevelMenu();
		selected = new Client();
	}

	private void createStatusMenu() {
		statuses = new ArrayList<>();
		SelectItem item = new SelectItem("Status1");
		statuses.add(item);
		item = new SelectItem("Status2");
		statuses.add(item);
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
			selected.setStatus(clientStatusTypeService.save(new ClientStatusType("code", statusSelected)));
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
		if (selected != null) {
			if (selected.getStatus() != null && selected.getLevel() != null) {
				statusSelected = selected.getStatus().getTitle();
				levelSelected = selected.getLevel().getTitle();
			}
		}
		show = true;
	}

	public void deleteSelected() {
		System.out.println("deleteSelected()" + selected.getId());
		clientService.delete(selected.getId());
	}

}
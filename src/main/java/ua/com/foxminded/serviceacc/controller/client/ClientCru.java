package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.menu.MenuModel;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@Named
@Getter
@Setter
@SessionScoped
@ManagedBean(name = "clientCru")
public class ClientCru implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private Client selected;

	@Inject
	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@Inject
	@ManagedProperty(value = "#{clientController}")
	private ClientController clientController;

	@Inject
	@ManagedProperty(value = "#{clientStatusTypeService}")
	private ClientStatusTypeService clientStatusTypeService;

	@Inject
	@ManagedProperty(value = "#{clientLevelTypeService}")
	private ClientLevelTypeService clientLevelTypeService;

	private List<SelectItem> statuses;
	private List<SelectItem> levels;
	private MenuModel level;
	private String statusSelected = "";
	private String levelSelected = "";

	@PostConstruct
	public void init() {
		createStatusMenu();
		createLevelMenu();
		// selected = new Client();
	}

	private void createStatusMenu() {
		statuses = new ArrayList<>();
		for (ClientStatusType current : clientStatusTypeService.findAll()) {
			System.out.println(current.getTitle());
			SelectItem item = new SelectItem(current.getTitle());
			statuses.add(item);
		}
	}

	private void createLevelMenu() {
		levels = new ArrayList<>();
		for (ClientLevelType current : clientLevelTypeService.findAll()) {
			System.out.println(current.getTitle());
			SelectItem item = new SelectItem(current.getTitle());
			levels.add(item);
		}
	}

	public void onOk() {
		if (selected.getId() == null) {
			selected = clientService.update(selected);
			ClientStatusType statusToSave = clientStatusTypeService.findByStatusName(statusSelected);
			ClientLevelType levelToSave = clientLevelTypeService.findByLevelName(levelSelected);
			selected.setStatus(statusToSave);
			selected.setLevel(levelToSave);
			clientService.update(selected);
		} else {
			selected = clientService.update(selected);
			ClientStatusType statusToSave = clientStatusTypeService.findByStatusName(statusSelected);
			ClientLevelType levelToSave = clientLevelTypeService.findByLevelName(levelSelected);
			selected.setStatus(statusToSave);
			selected.setLevel(levelToSave);
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
		createStatusMenu();
		createLevelMenu();
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
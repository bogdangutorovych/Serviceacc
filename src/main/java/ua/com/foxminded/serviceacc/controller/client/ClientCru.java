package ua.com.foxminded.serviceacc.controller.client;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
//@Named
////@Getter
////@Setter
@SessionScoped
@Scope("view")
//@ManagedBean(name = "clientCru")
public class ClientCru implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private Client selected;

	@Autowired
//	@ManagedProperty(value = "#{clientService}")
	private ClientService clientService;

	@Autowired
//	@ManagedProperty(value = "#{clientController}")
	private ClientController clientController;

	@Autowired
//	@ManagedProperty(value = "#{clientStatusTypeService}")
	private ClientStatusTypeService clientStatusTypeService;

	@Autowired
//	@ManagedProperty(value = "#{clientLevelTypeService}")
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


	//Getters and Setters

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public Client getSelected() {
		return selected;
	}

	public void setSelected(Client selected) {
		this.selected = selected;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public ClientController getClientController() {
		return clientController;
	}

	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}

	public ClientStatusTypeService getClientStatusTypeService() {
		return clientStatusTypeService;
	}

	public void setClientStatusTypeService(ClientStatusTypeService clientStatusTypeService) {
		this.clientStatusTypeService = clientStatusTypeService;
	}

	public ClientLevelTypeService getClientLevelTypeService() {
		return clientLevelTypeService;
	}

	public void setClientLevelTypeService(ClientLevelTypeService clientLevelTypeService) {
		this.clientLevelTypeService = clientLevelTypeService;
	}

	public List<SelectItem> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<SelectItem> statuses) {
		this.statuses = statuses;
	}

	public List<SelectItem> getLevels() {
		return levels;
	}

	public void setLevels(List<SelectItem> levels) {
		this.levels = levels;
	}

	public MenuModel getLevel() {
		return level;
	}

	public void setLevel(MenuModel level) {
		this.level = level;
	}

	public String getStatusSelected() {
		return statusSelected;
	}

	public void setStatusSelected(String statusSelected) {
		this.statusSelected = statusSelected;
	}

	public String getLevelSelected() {
		return levelSelected;
	}

	public void setLevelSelected(String levelSelected) {
		this.levelSelected = levelSelected;
	}
}
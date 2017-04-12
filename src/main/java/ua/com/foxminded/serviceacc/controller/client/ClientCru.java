package ua.com.foxminded.serviceacc.controller.client;

import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionScoped
@ManagedBean
public class ClientCru implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean show = false;

	private Client selected;

	@Autowired
	private ClientService clientService;

	@Autowired
	private ClientController clientController;

	@Autowired
	private ClientStatusTypeService clientStatusTypeService;

	@Autowired
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

	public boolean isShow() {
		return this.show;
	}

	public Client getSelected() {
		return this.selected;
	}

	public ClientService getClientService() {
		return this.clientService;
	}

	public ClientController getClientController() {
		return this.clientController;
	}

	public ClientStatusTypeService getClientStatusTypeService() {
		return this.clientStatusTypeService;
	}

	public ClientLevelTypeService getClientLevelTypeService() {
		return this.clientLevelTypeService;
	}

	public List<SelectItem> getStatuses() {
		return this.statuses;
	}

	public List<SelectItem> getLevels() {
		return this.levels;
	}

	public MenuModel getLevel() {
		return this.level;
	}

	public String getStatusSelected() {
		return this.statusSelected;
	}

	public String getLevelSelected() {
		return this.levelSelected;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void setSelected(Client selected) {
		this.selected = selected;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}

	public void setClientStatusTypeService(ClientStatusTypeService clientStatusTypeService) {
		this.clientStatusTypeService = clientStatusTypeService;
	}

	public void setClientLevelTypeService(ClientLevelTypeService clientLevelTypeService) {
		this.clientLevelTypeService = clientLevelTypeService;
	}

	public void setStatuses(List<SelectItem> statuses) {
		this.statuses = statuses;
	}

	public void setLevels(List<SelectItem> levels) {
		this.levels = levels;
	}

	public void setLevel(MenuModel level) {
		this.level = level;
	}

	public void setStatusSelected(String statusSelected) {
		this.statusSelected = statusSelected;
	}

	public void setLevelSelected(String levelSelected) {
		this.levelSelected = levelSelected;
	}
}
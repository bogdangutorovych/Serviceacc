package ua.com.foxminded.serviceacc.controller.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.service.ManagerService;

@Controller
@ViewScoped
@ManagedBean
public class ManagerController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Manager selectedManager;
	
	private List<Manager> list;
	
	private ManagerService managerService;
	
	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@PostConstruct
	public void init() {
		list = managerService.findAll();
	}

	public void add() {
		selectedManager = new Manager();
	}
	
	public void delete() {
		list.remove(selectedManager);
		managerService.delete(selectedManager.getId());
		selectedManager = null;
	}
	
	public void onOk() {
		if (selectedManager.getId() == null) {
			list.add(selectedManager);
		}

		managerService.update(selectedManager);
	}

	public Manager getSelectedManager() {
		return selectedManager;
	}

	public void setSelectedManager(Manager selectedManager) {
		this.selectedManager = selectedManager;
	}

	public List<Manager> getList() {
		return list;
	}

}

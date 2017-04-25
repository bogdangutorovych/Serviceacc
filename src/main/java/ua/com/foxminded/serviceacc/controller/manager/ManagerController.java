package ua.com.foxminded.serviceacc.controller.manager;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;
import ua.com.foxminded.serviceacc.service.ManagerService;

@Controller
@ViewScoped
@ManagedBean
public class ManagerController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);

	private static final long serialVersionUID = 1L;

	private Manager selectedManager;

	private List<Manager> managers;
	private List<ManagerInformationType> managerInformationTypeList;

	private ManagerService managerService;
	private ManagerInformationTypeService managerInformationTypeService;

	@Autowired
	public ManagerController(ManagerService managerService,
			ManagerInformationTypeService managerInformationTypeService) {
		this.managerService = managerService;
		this.managerInformationTypeService = managerInformationTypeService;
	}

	@PostConstruct
	public void init() {
		managers = managerService.findAll();
		managerInformationTypeList = managerInformationTypeService.findAll();
	}

	public ManagerInformation getInfoByType(ManagerInformationType managerInformationType) {

		for (ManagerInformation managerInfo : selectedManager.getManagerInformationSet()) {
			if (managerInfo.getManagerInformationType().equals(managerInformationType)) {
				return managerInfo;
			}
		}

		ManagerInformation managerInformation = new ManagerInformation();
		managerInformation.setManagerInformationType(managerInformationType);
		managerInformation.setActive(true);
		selectedManager.getManagerInformationSet().add(managerInformation);

		return managerInformation;
	}

	public void add() {
		selectedManager = new Manager();
	}

	public void delete() {
		managers.remove(selectedManager);
		managerService.delete(selectedManager.getId());
		selectedManager = null;
	}

	public void onOk() {
		if (selectedManager.getId() == null) {
			managers.add(selectedManager);
		}
		Iterator<ManagerInformation> iteratorInfos = selectedManager.getManagerInformationSet().iterator();
		while (iteratorInfos.hasNext()) {
			if (iteratorInfos.next().getContent().isEmpty()) {
				iteratorInfos.remove();
			}
		}
		Manager manager = managerService.update(selectedManager);
		managers.set(managers.indexOf(selectedManager), manager);
	}

	public Manager getSelectedManager() {
		return selectedManager;
	}

	public void setSelectedManager(Manager selectedManager) {
		this.selectedManager = selectedManager;
	}

	public List<Manager> getList() {
		return managers;
	}

	public ManagerInformationTypeService getManagerInformationTypeService() {
		return managerInformationTypeService;
	}

	public void setManagerInformationTypeService(ManagerInformationTypeService managerInformationTypeService) {
		this.managerInformationTypeService = managerInformationTypeService;
	}

	public List<ManagerInformationType> getManagerInformationTypeList() {
		return managerInformationTypeList;
	}

	public void setManagerInformationTypeList(List<ManagerInformationType> managerInformationTypeList) {
		this.managerInformationTypeList = managerInformationTypeList;
	}

}

package ua.com.foxminded.serviceacc.controller.manager;

import java.io.Serializable;
import java.util.ArrayList;
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
import ua.com.foxminded.serviceacc.service.ManagerInformationService;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;
import ua.com.foxminded.serviceacc.service.ManagerService;

@Controller
@ViewScoped
@ManagedBean
public class ManagerController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);

	private static final long serialVersionUID = 1L;

	private Manager selectedManager;
    private List<ManagerInformation> managerInfo;

	private List<Manager> managers;
	private List<ManagerInformationType> managerInformationTypeList;

	private ManagerService managerService;
	private ManagerInformationTypeService managerInformationTypeService;
	private ManagerInformationService managerInformationService;

	@Autowired
	public ManagerController(ManagerService managerService,
			ManagerInformationTypeService managerInformationTypeService,
			ManagerInformationService managerInformationService) {
		this.managerService = managerService;
		this.managerInformationTypeService = managerInformationTypeService;
		this.managerInformationService = managerInformationService;
	}

	@PostConstruct
	public void init() {
		managers = managerService.findAll();
		managerInformationTypeList = managerInformationTypeService.findAll();
	}

	public void add() {
		selectedManager = new Manager();
		managerInfo = getManagerInformationList();
	}

	public void delete() {
		managers.remove(selectedManager);
		managerService.delete(selectedManager.getId());
		selectedManager = null;
	}

	public void onOk() {
	    if(selectedManager.getId() == null) {
            managers.add(selectedManager);
            managerService.update(selectedManager);
        }

        Iterator<ManagerInformation> iteratorInfos = managerInfo.iterator();
        while(iteratorInfos.hasNext()){
            ManagerInformation info = iteratorInfos.next(); 
            if (info.getContent().isEmpty() && info.getId() !=null) {
                managerInformationService.update(info);
                managerInformationService.delete(info.getId());
            } else if (info.getContent().isEmpty() && info.getId() == null) {
            } else {
                managerInformationService.update(info);
            }
        }
        Manager updated = managerService.update(selectedManager);
        int i = managers.indexOf(selectedManager);
        managers.set(i, updated);
        selectedManager = updated;
    }

	public void setSelectedManager(Manager selectedManager) {
		this.selectedManager = selectedManager;
	}

	public Manager getSelectedManager() {
        return selectedManager;
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
	
	public ManagerInformation getInfoByType(ManagerInformationType managerInformationType) {

	    if (selectedManager.getId() != null) {
            for (ManagerInformation managerInfo : managerInformationService.findByManager(selectedManager)) {
                if (managerInfo.getManagerInformationType().equals(managerInformationType)) {
                    return managerInfo;
                }
            }
        }

        ManagerInformation managerInfo = new ManagerInformation();
        managerInfo.setManagerInformationType(managerInformationType);
        managerInfo.setManager(selectedManager);
        return managerInfo;
    }
	
	public List<ManagerInformationType> getInfoTypeList(){ return managerInformationTypeService.findAll();}
	
    public List<ManagerInformation> getManagerInformationList() {
        managerInfo = new ArrayList<>();
        for (ManagerInformationType type : getInfoTypeList()) {
            ManagerInformation info = getInfoByType(type);
            managerInfo.add(info);
        } 
        return managerInfo;
    }

}

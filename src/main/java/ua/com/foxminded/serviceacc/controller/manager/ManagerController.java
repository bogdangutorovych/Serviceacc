package ua.com.foxminded.serviceacc.controller.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.service.ManagerInformationService;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;
import ua.com.foxminded.serviceacc.service.ManagerService;

@Named
@ViewScoped
@ManagedBean
public class ManagerController implements Serializable {

	private static final Logger log = LoggerFactory.getLogger(ManagerController.class);
	private static final long serialVersionUID = 1L;

	private Manager selectedManager;
    private List<ManagerInformation> managerInfo;

	private List<ManagerInformationType> managerInformationTypeList;

	private final ManagerService managerService;
	private final ManagerInformationTypeService managerInformationTypeService;
	private final ManagerInformationService managerInformationService;

	@Inject
	public ManagerController(ManagerService managerService,
			ManagerInformationTypeService managerInformationTypeService,
			ManagerInformationService managerInformationService) {
		this.managerService = managerService;
		this.managerInformationTypeService = managerInformationTypeService;
		this.managerInformationService = managerInformationService;
	}

	@PostConstruct
	public void init() {
		managerInformationTypeList = managerInformationTypeService.findAll();
	}

	public void add() {
		selectedManager = new Manager();
		managerInfo = getManagerInformationList();
	}

	public void onOk() {
        //save or update manager
	    if(selectedManager.getId() == null) {
            managerService.save(selectedManager);
        }else{
            managerService.update(selectedManager);
        }

        //save or update information
        Iterator<ManagerInformation> iteratorInfos = managerInfo.iterator();
        while(iteratorInfos.hasNext()){
            ManagerInformation info = iteratorInfos.next();
            if (!info.getContent().isEmpty()) {
                managerInformationService.update(info);
            } else if (info.getContent().isEmpty() && info.getId() != null){
                managerInformationService.delete(info.getId());
            }
        }

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

    public List<ManagerInformationType> getInfoTypeList(){ return managerInformationTypeList;}

    public List<ManagerInformation> getManagerInformationList() {
        managerInfo = new ArrayList<>();
        for (ManagerInformationType type : getInfoTypeList()) {
            ManagerInformation info = getInfoByType(type);
            managerInfo.add(info);
        }
        return managerInfo;
    }

	public void setSelectedManager(Manager selectedManager) {
		this.selectedManager = selectedManager;
	}

	public Manager getSelectedManager() {
        return selectedManager;
    }

	public ManagerInformationTypeService getManagerInformationTypeService() {
		return managerInformationTypeService;
	}

	public List<ManagerInformationType> getManagerInformationTypeList() {
		return managerInformationTypeList;
	}

	public void setManagerInformationTypeList(List<ManagerInformationType> managerInformationTypeList) {
		this.managerInformationTypeList = managerInformationTypeList;
	}
}

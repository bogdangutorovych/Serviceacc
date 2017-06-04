package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;

@Named
@javax.faces.view.ViewScoped
public class ManagerInformationTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ManagerInformationType selectedManagerInfoType;

    private static List<ManagerInformationType> managerInformationTypeList;

    private ManagerInformationTypeService managerInformationTypeService;

    @Inject
    public ManagerInformationTypeController(ManagerInformationTypeService cltService) {
        this.managerInformationTypeService = cltService;
    }

    @PostConstruct
    public void init() {
        managerInformationTypeList = managerInformationTypeService.findAll();
    }

    public ManagerInformationTypeService getManagerInformationTypeService() {
        return managerInformationTypeService;
    }

    public List<ManagerInformationType> getManagerInformationTypeList() {
        return managerInformationTypeList;
    }

    public ManagerInformationType getSelectedManagerInfoType() {
        return selectedManagerInfoType;
    }

    public void setSelectedManagerInfoType(ManagerInformationType selectedManagerInfoType) {
        this.selectedManagerInfoType = selectedManagerInfoType;
    }

    public void add() {
        selectedManagerInfoType = new ManagerInformationType("", "");
        managerInformationTypeList.add(selectedManagerInfoType);
    }

    public void delete() {
        managerInformationTypeList.remove(selectedManagerInfoType);
        managerInformationTypeService.delete(selectedManagerInfoType.getId());
        selectedManagerInfoType = null;
    }

    public void onRowEdit(RowEditEvent event) {
        managerInformationTypeService.save((ManagerInformationType) event.getObject());
        selectedManagerInfoType = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ManagerInformationType info = (ManagerInformationType) event.getObject();
        if (info.getId() == null) {
            managerInformationTypeList.remove(info);
            selectedManagerInfoType = null;
        }
    }
}

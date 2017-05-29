package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;

@Named
@javax.faces.view.ViewScoped
public class ManagerInformationTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ManagerInformationType selected;

    private static List<ManagerInformationType> managerInformationTypeList;
    private ManagerInformationTypeService managerInformationTypeService;

    private static final Logger log = LoggerFactory.getLogger(ManagerInformationTypeController.class);

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

    public ManagerInformationType getSelected() {
        return selected;
    }

    public void setSelected(ManagerInformationType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ManagerInformationType("", "");
        managerInformationTypeList.add(selected);
    }

    public void delete() {
        managerInformationTypeList.remove(selected);
        managerInformationTypeService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        managerInformationTypeService.save((ManagerInformationType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ManagerInformationType info = (ManagerInformationType) event.getObject();
        if (info.getId() == null) {
            managerInformationTypeList.remove(info);
            selected = null;
        }
    }
}
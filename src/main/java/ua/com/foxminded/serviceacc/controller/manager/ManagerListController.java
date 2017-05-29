package ua.com.foxminded.serviceacc.controller.manager;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.service.ManagerService;

/**
 * Created by andreb on 18.05.17.
 */
@Named
@ViewScoped
public class ManagerListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ManagerListController.class);
    private static final long serialVersionUID = 1L;

    private List<Manager> managerList;
    private final ManagerService managerService;

    @Inject
    ManagerListController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostConstruct
    public void init() {
        updateManagerListFromDB();
    }

    public void updateManagerListFromDB(){
        managerList = managerService.findAll();
    }

    public void deleteManager(Manager manager) {
        managerService.delete(manager.getId());
    }

    public int countActiveClient(Manager manager){
        log.debug("count CLients for manager: " + manager);
        return managerService.countClient(manager);
    }

    public List<Manager> getManagerList() {
        return managerList;
    }
}

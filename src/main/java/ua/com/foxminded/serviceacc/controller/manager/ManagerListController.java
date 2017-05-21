package ua.com.foxminded.serviceacc.controller.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.service.ManagerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andreb on 18.05.17.
 */
@Named
@ViewScoped
@ManagedBean
public class ManagerListController implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(ManagerListController.class);
    private static final long serialVersionUID = 1L;

    private List<Manager> managerList;
    private final ManagerService managerService;

    @Inject
    ManagerListController(ManagerService managerService){
        this.managerService = managerService;
    }

    @PostConstruct
    public void init() {
        updateManagerListFromDB();
    }

    public void deleteManager(Manager manager) {
        managerService.delete(manager.getId());
        updateManagerListFromDB();
    }

    public void updateManagerListFromDB(){
        managerList = managerService.findAll();
    }



    public List<Manager> getManagerList() {
        return managerList;
    }
}


package ua.com.foxminded.serviceacc.controller.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.ManagerInformation;
import ua.com.foxminded.serviceacc.model.ManagerInformationType;
import ua.com.foxminded.serviceacc.service.ManagerInformationService;
import ua.com.foxminded.serviceacc.service.ManagerInformationTypeService;
import ua.com.foxminded.serviceacc.service.ManagerService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by andreb on 21.05.17.
 */
@Named
@ViewScoped
@ManagedBean
public class ManagerCapacityBean implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(ManagerCapacityBean.class);
    private static final long serialVersionUID = 1L;

    private final ManagerService managerService;
    private final ManagerInformationTypeService managerInformationTypeService;
    private final ManagerInformationService managerInformationService;

    private ManagerInformationType clientsLimitType;
    private final String titleForLimitType = "clients limit"; // common title content for Clients Limit By Manager

    @Inject
    public ManagerCapacityBean(ManagerService managerService,
                             ManagerInformationTypeService managerInformationTypeService,
                             ManagerInformationService managerInformationService) {
        this.managerService = managerService;
        this.managerInformationTypeService = managerInformationTypeService;
        this.managerInformationService = managerInformationService;
    }

    @PostConstruct
    public void init() {
        clientsLimitType = managerInformationTypeService.findByTitle(titleForLimitType);
    }

    /*
     *  This method do calculate of workload by manager
     *  Return array of 2 numbers: current load and capacity count by manager2
     */
    public String workload(Manager manager){
        int[] workload = new int[2];
        ManagerInformation capacity = managerInformationService.findByTypeAndManager(clientsLimitType, manager);
        log.debug("workload capacity: " + capacity);
        int capacityCount = -1;

        try{
            if(capacity != null){
                capacityCount = Integer.parseInt(capacity.getContent());
            }
        }catch(NumberFormatException e){
            capacityCount = -2;
        }
        workload[1] = capacityCount;
        int currentLoad = managerService.countClient(manager);
        log.debug("Current load: " + currentLoad);
        log.debug("Clients: " + managerService.findClients(manager));
        workload[0] = currentLoad;
        log.debug("Workload: " + workload);
        return workload[0] + "/" + workload[1];
    }


}

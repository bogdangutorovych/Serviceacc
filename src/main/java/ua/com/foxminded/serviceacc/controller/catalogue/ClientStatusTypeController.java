package ua.com.foxminded.serviceacc.controller.catalogue;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Controller
@ManagedBean
@ViewScoped
public class ClientStatusTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<ClientStatusType> statusList;

    private ClientStatusTypeService cstService;
    @Autowired
    public ClientStatusTypeController(ClientStatusTypeService cstService) {
        this.cstService = cstService;
    }

    @PostConstruct
    public void init() {
        statusList = cstService.findAll();
    }

    public List<ClientStatusType> getStatusList() {
        return statusList;
    }

    public void setService(ClientStatusTypeService service) {
        this.cstService = service;
    }

    public void add() {
        ClientStatusType newStatus = new ClientStatusType("","");
        statusList.add(newStatus);
        cstService.save(newStatus);
    }

    public void delete(ClientStatusType status) {
        statusList.remove(status);
        cstService.delete(status.getId());
    }

    public void onRowEdit(RowEditEvent event) {
        cstService.save(((ClientStatusType) event.getObject()));
    }
}

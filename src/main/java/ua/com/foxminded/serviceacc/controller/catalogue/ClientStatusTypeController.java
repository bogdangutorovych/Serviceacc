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

    private ClientStatusType selected;

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

    public ClientStatusTypeService getCstService() {
        return cstService;
    }

    public List<ClientStatusType> getStatusList() {
        return statusList;
    }

    public ClientStatusType getSelected() {
        return selected;
    }

    public void setSelected(ClientStatusType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ClientStatusType("", "");
        statusList.add(selected);
    }

    public void delete() {
        statusList.remove(selected);
        cstService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        cstService.save((ClientStatusType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ClientStatusType status = (ClientStatusType) event.getObject();
        if (status.getId() == null) {
            statusList.remove(status);
        }
    }

}
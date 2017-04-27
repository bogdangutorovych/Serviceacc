package ua.com.foxminded.serviceacc.controller.catalogue;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.ContractStatus;
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

    private ContractStatus selected;

    private static List<ContractStatus> statusList;

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

    public List<ContractStatus> getStatusList() {
        return statusList;
    }

    public ContractStatus getSelected() {
        return selected;
    }

    public void setSelected(ContractStatus selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ContractStatus("", "");
        statusList.add(selected);
    }

    public void delete() {
        statusList.remove(selected);
        cstService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        cstService.save((ContractStatus) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ContractStatus status = (ContractStatus) event.getObject();
        if (status.getId() == null) {
            statusList.remove(status);
            selected = null;
        }
    }

}
package ua.com.foxminded.serviceacc.controller.catalogue;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Controller
@ManagedBean
@ViewScoped
public class ClientLevelTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ClientLevelType selected;

    private static List<ClientLevelType> LevelList;

    private ClientLevelTypeService cltService;
    @Autowired
    public ClientLevelTypeController(ClientLevelTypeService cltService) {
        this.cltService = cltService;
    }

    @PostConstruct
    public void init() {
        LevelList = cltService.findAll();
    }

    public ClientLevelTypeService getCltService() {
        return cltService;
    }

    public List<ClientLevelType> getLevelList() {
        return LevelList;
    }

    public ClientLevelType getSelected() {
        return selected;
    }

    public void setSelected(ClientLevelType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ClientLevelType("", "");
        LevelList.add(selected);
    }

    public void delete() {
        LevelList.remove(selected);
        cltService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        cltService.save((ClientLevelType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ClientLevelType Level = (ClientLevelType) event.getObject();
        if (Level.getId() == null) {
            LevelList.remove(Level);
            selected = null;
        }
    }

}
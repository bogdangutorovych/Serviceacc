package ua.com.foxminded.serviceacc.controller.catalogue;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.ContactType;
import ua.com.foxminded.serviceacc.service.ContactTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Controller
@ManagedBean
@ViewScoped
public class ContactTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ContactType selected;

    private static List<ContactType> contactTypeList;

    private ContactTypeService ctService;
    @Autowired
    public ContactTypeController(ContactTypeService ctService) {
        this.ctService = ctService;
    }

    @PostConstruct
    public void init() {
        contactTypeList = ctService.findAll();
    }

    public ContactTypeService getCtService() {
        return ctService;
    }

    public List<ContactType> getContactTypeList() {
        return contactTypeList;
    }

    public ContactType getSelected() {
        return selected;
    }

    public void setSelected(ContactType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ContactType("", "");
        contactTypeList.add(selected);
    }

    public void delete() {
        contactTypeList.remove(selected);
        ctService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        ctService.save((ContactType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ContactType Level = (ContactType) event.getObject();
        if (Level.getId() == null) {
            contactTypeList.remove(Level);
            selected = null;
        }
    }

}
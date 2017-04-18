package ua.com.foxminded.serviceacc.controller;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Contact;
import ua.com.foxminded.serviceacc.service.ContactService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/** Created by Grischenko Maxim on 17.04.17. */

@Controller
@ManagedBean
@ViewScoped
public class ContactController {

    private static final long serialVersionUID = 1L;

    public Client client;

    private Contact selected;

    private static List<Contact> list;

    private ContactService contactService;
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public List<Contact> getContactList(Client client) {
        return list;
    }

    public Contact getSelected() {
        return selected;
    }

    public void setSelected(Contact selected) {
        this.selected = selected;
    }


    public void add() {
        selected = new Contact();
        list.add(selected);
    }

    public void delete() {
        list.remove(selected);
        contactService.delete(selected.getId());
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        //contactService.save((Contact) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        Contact contact = (Contact) event.getObject();
        if (contact.getId() == null) {
            list.remove(contact);
            selected = null;
        }
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

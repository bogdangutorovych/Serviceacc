package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

/**
 * Created by andreb on 18.05.17.
 */

@Named
@ViewScoped
public class ClientListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientListController.class);
    private static final long serialVersionUID = 1L;

    private List<Client> clientList;
    private final ClientService clientService;

    @Inject
    public ClientListController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostConstruct
    public void init() {
        if(!FacesContext.getCurrentInstance().isPostback()) {
            prepareData();
        }
    }

    public void prepareData(){
        clientList = clientService.findAll();
        log.debug("Client list prepared");
    }

    public void deleteClient(Client client) {
        clientService.delete(client);
        clientList.remove(client);
    }

    public List<Client> getClientList() {
        return clientList;
    }
}

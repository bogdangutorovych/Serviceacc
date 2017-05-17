package ua.com.foxminded.serviceacc.controller.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

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
public class ClientListController implements Serializable{

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
        updateClientListFromDB();
    }

    public void deleteClient(Client client) {
        clientService.delete(client.getId());
        updateClientListFromDB();
    }

    public void updateClientListFromDB(){
        clientList = clientService.findAll();
        log.debug("Update ClientList from DB: " + clientList);
    }

    public List<Client> getClientList() {
        return clientList;
    }
}

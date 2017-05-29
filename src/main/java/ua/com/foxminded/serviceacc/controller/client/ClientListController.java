package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
@RequestScoped
public class ClientListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientListController.class);
    private static final long serialVersionUID = 1L;

    private List<Client> list;
    private final ClientService clientService;

    @PostConstruct
    public void inits() {
        list = clientService.findAll();
    }

    @Inject
    public ClientListController(ClientService clientService) {
        this.clientService = clientService;
    }

    public void deleteClient(Client client) {
        clientService.delete(client.getId());
        list.remove(client);
    }

    public List<Client> getList() {
        return list;
    }

}

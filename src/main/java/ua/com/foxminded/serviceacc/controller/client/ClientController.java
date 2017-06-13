package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.controller.catalogue.ClientInformationTypeController;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@ViewScoped
public class ClientController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private static final long serialVersionUID = 1L;

    private Client selectedClient;

    private List<Deal> clientDeals;

    private final ClientService clientService;
    private final DealService dealService;
    private final ClientInformationTypeController typeController;

    @Inject
    public ClientController(ClientService clientService, DealService dealService,
                            ClientInformationTypeController typeController) {
        this.clientService = clientService;
        this.dealService = dealService;
        this.typeController = typeController;
    }

    @PostConstruct
    public void init() {
        prepareData();
        log.debug("initialized");
    }

    public void prepareData(){
        log.debug("Preparing data...");
        if (selectedClient != null && selectedClient.getId() != null){
            //load client with clientInformation eagerly
            selectedClient = clientService.
                findByIdWithClientInformation(selectedClient.getId());
            clientDeals = dealService.findByClient(selectedClient);
            log.debug("Fetch client: " + selectedClient +
                "Info: " + selectedClient.getInformation());
        }

    }

    public void add() {
        selectedClient = new Client();
        //fill empty info
        for (ClientInformationType type : typeController.getClientInformationTypeList()){
            ClientInformation info = new ClientInformation();
            info.setClientInformationType(type);
            selectedClient.addClientInformation(info);
        }
    }

    public void removeDealFromClient(Deal deal) {
        dealService.delete(deal.getId());
        clientDeals.remove(deal);
    }

    public void onOk() {
        // save or update client
        clientService.save(selectedClient);

    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public List<Deal> getClientDeals() {
        return clientDeals;
    }

    public void setClientDeals(List<Deal> clientDeals) {
        this.clientDeals = clientDeals;
    }

}

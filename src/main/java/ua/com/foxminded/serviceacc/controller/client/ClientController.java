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

import ua.com.foxminded.serviceacc.controller.catalogue.ConfigController;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.service.ClientInformationService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.DealService;

@Named
@ViewScoped
public class ClientController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private static final long serialVersionUID = 1L;

    private Client selectedClient;

    private List<ClientInformation> clientInfo;
    private List<Deal> clientDeals;

    private final ClientService clientService;
    private final ClientInformationService clientInformationService;
    private final ConfigController configController;
    private final DealService dealService;

    @Inject
    public ClientController(ClientService clientService, ClientInformationService clientInformationService,
            ConfigController configController, DealService dealService) {
        this.clientService = clientService;
        this.clientInformationService = clientInformationService;
        this.configController = configController;
        this.dealService = dealService;
    }

    @PostConstruct
    public void init() {
        clientDeals = dealService.findByClient(selectedClient);
    }

    public void add() {
        selectedClient = new Client();
        getActualLists();
    }

    public void removeDealFromClient(Deal deal) {
        dealService.delete(deal.getId());
        clientDeals.remove(deal);
    }

    public void getActualLists() {
        clientInfo = getClientInfo();
    }

    public void onOk() {
        // save or update client
        clientService.save(selectedClient);

        // Save or update informations
        Iterator<ClientInformation> iteratorInfos = clientInfo.iterator();
        while (iteratorInfos.hasNext()) {
            ClientInformation info = iteratorInfos.next();
            if (!info.getContent().isEmpty()) {
                clientInformationService.save(info);
            } else if (info.getContent().isEmpty() && info.getId() != null) {
                clientInformationService.delete(info.getId());
            }
        }
    }

    public ClientInformation getInfoByType(ClientInformationType clientInformationType) {

        if (selectedClient.getId() != null) {
            for (ClientInformation clientInfo : clientInformationService.findByClient(selectedClient)) {
                if (clientInfo.getClientInformationType().equals(clientInformationType)) {
                    return clientInfo;
                }
            }
        }

        ClientInformation clientInfo = new ClientInformation();
        clientInfo.setClientInformationType(clientInformationType);
        clientInfo.setClient(selectedClient);
        return clientInfo;
    }

    public List<ClientInformationType> getInfoTypeList() {
        return configController.getClientInformationTypeList();
    }

    public List<ClientInformation> getClientInfo() {
        clientInfo = new ArrayList<>();
        for (ClientInformationType type : getInfoTypeList()) {
            ClientInformation info = getInfoByType(type);
            clientInfo.add(info);
        }
        return clientInfo;
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

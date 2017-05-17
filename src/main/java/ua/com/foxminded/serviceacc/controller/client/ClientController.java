package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.controller.catalogue.ConfigController;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationService;
import ua.com.foxminded.serviceacc.service.ClientService;

@Named
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private static final long serialVersionUID = 1L;

    private Client selectedClient;


    private List<ClientInformation> clientInfo;

    private final ClientService clientService;
    private final ClientInformationService clientInformationService;
    private final ConfigController configController;

    @Inject
    public ClientController(ClientService clientService, ClientInformationService clientInformationService, ConfigController configController) {
        this.clientService = clientService;
        this.clientInformationService = clientInformationService;
        this.configController = configController;
    }

    @PostConstruct
    public void init() {
    }

    public void add() {
        selectedClient = new Client();
        getActualLists();
    }

    public void getActualLists() {
        clientInfo = getClientInformationList();
    }

    public void onOk() {
        // save or update client
        if (selectedClient.getId() == null) {
            clientService.save(selectedClient);
        } else {
            clientService.update(selectedClient);
        }

        // Save or update informations
        Iterator<ClientInformation> iteratorInfos = clientInfo.iterator();
        while (iteratorInfos.hasNext()) {
            ClientInformation info = iteratorInfos.next();
            if (info.getContent().isEmpty() && info.getId() != null) {
                clientInformationService.update(info);
                clientInformationService.delete(info.getId());
            } else if (info.getContent().isEmpty() && info.getId() == null) {
            } else {
                clientInformationService.update(info);
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

    public List<ClientInformation> getClientInformationList() {
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


}

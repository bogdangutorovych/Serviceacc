package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientInformationService;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Controller
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    private static final long serialVersionUID = 1L;

    private Client selectedClient;
    private static List<Client> list;

    private List<ClientStatusType> availableStatuses;
    private List<ClientLevelType> availableLevels;
    private List<ClientInformation> clientInfo;

    private final ClientService clientService;
    private final ClientStatusTypeService cstService;
    private final ClientLevelTypeService cltService;
    private final ClientInformationTypeService citService;
    private final ClientInformationService ciService;

    @Autowired
    public ClientController(ClientService clientService, ClientStatusTypeService cstService,
            ClientLevelTypeService cltService, ClientInformationTypeService citService,
            ClientInformationService ciService) {
        this.clientService = clientService;
        this.cstService = cstService;
        this.cltService = cltService;
        this.citService = citService;
        this.ciService = ciService;
    }

    @PostConstruct
    public void init() {
        list = clientService.findAll();
    }

    public void add() {
        selectedClient = new Client();
        getActualLists();
    }

    public void getActualLists() {
        availableStatuses = cstService.findAll();
        availableLevels = cltService.findAll();
        clientInfo = getClientInformationList();
    }

    public void onOk() {
        if (selectedClient.getId() == null) {
            list.add(selectedClient);
            clientService.update(selectedClient);
        }

        Iterator<ClientInformation> iteratorInfos = clientInfo.iterator();
        while (iteratorInfos.hasNext()) {
            ClientInformation info = iteratorInfos.next();
            if (info.getContent().isEmpty() && info.getId() != null) {
                ciService.update(info);
                ciService.delete(info.getId());
            } else if (info.getContent().isEmpty() && info.getId() == null) {
            } else {
                ciService.update(info);
            }
        }
        Client updated = clientService.update(selectedClient);
        int i = list.indexOf(selectedClient);
        list.set(i, updated);
        selectedClient = updated;
    }

    public void delete() {
        list.remove(selectedClient);
        clientService.delete(selectedClient.getId());
        selectedClient = null;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public List<Client> getList() {
        return list;
    }

    public List<ClientStatusType> getAvailableStatuses() {
        return availableStatuses;
    }

    public List<ClientLevelType> getAvailableLevels() {
        return availableLevels;
    }

    public ClientInformation getInfoByType(ClientInformationType clientInformationType) {

        if (selectedClient.getId() != null) {
            for (ClientInformation clientInfo : ciService.findByClient(selectedClient)) {
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
        return citService.findAll();
    }

    public List<ClientInformation> getClientInformationList() {
        clientInfo = new ArrayList<>();
        for (ClientInformationType type : getInfoTypeList()) {
            ClientInformation info = getInfoByType(type);
            clientInfo.add(info);
        }
        return clientInfo;
    }
}

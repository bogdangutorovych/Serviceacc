package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;
import ua.com.foxminded.serviceacc.service.ClientService;

@Named
@ViewScoped
public class ClientController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private static final long serialVersionUID = 1L;

    private Client selected;
    private ClientInformationTypeService clientInfoTypeService;
    private ClientService clientService;

    @Inject
    public ClientController(ClientService clientService, ClientInformationTypeService clientInfoTypeService) {
        this.clientService = clientService;
        this.clientInfoTypeService = clientInfoTypeService;
    }

    public void add() {
        selected = new Client();
        populateClientInfoWithInitData();
    }

    public void populateClientInfoWithInitData() {
        List<ClientInformation> clientInfoList = new ArrayList<>();
        List<ClientInformationType> clientInfoTypes = clientInfoTypeService.findAll();

        for (int i = 0; i < clientInfoTypes.size(); i++) {
            clientInfoList.add(new ClientInformation("", clientInfoTypes.get(i), false));
        }
        selected.setClientInfoList(clientInfoList);
    }

    public void onOk() {
        clientService.save(selected);
    }

    public void setSelected(Client selectedClient) {
        this.selected = selectedClient;
    }

    public Client getSelected() {
        return selected;
    }

}

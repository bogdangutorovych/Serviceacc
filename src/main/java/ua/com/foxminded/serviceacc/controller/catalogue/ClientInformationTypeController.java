package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

@Named
@javax.faces.view.ViewScoped
public class ClientInformationTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private ClientInformationType selectedClientInfoType;

    private static List<ClientInformationType> clientInformationTypeList;

    private ClientInformationTypeService clientInformationTypeService;
    private ConfigController configController;

    @Inject
    public ClientInformationTypeController(ClientInformationTypeService cltService, ConfigController configController) {
        this.clientInformationTypeService = cltService;
        this.configController = configController;
    }

    @PostConstruct
    public void init() {
        clientInformationTypeList = configController.getClientInformationTypeList();
    }

    public ClientInformationTypeService getClientInformationTypeService() {
        return clientInformationTypeService;
    }

    public List<ClientInformationType> getClientInformationTypeList() {
        return clientInformationTypeList;
    }

    public ClientInformationType getSelectedClientInfoType() {
        return selectedClientInfoType;
    }

    public void setSelectedClientInfoType(ClientInformationType selectedClientInfoType) {
        this.selectedClientInfoType = selectedClientInfoType;
    }

    public void add() {
        selectedClientInfoType = new ClientInformationType("", "");
        clientInformationTypeList.add(selectedClientInfoType);
    }

    public void delete() {
        configController.deleteClientInformationType(selectedClientInfoType.getId());
        clientInformationTypeList.remove(selectedClientInfoType);
        selectedClientInfoType = null;
    }

    public void onRowEdit(RowEditEvent event) {
        configController.saveClientInformationType((ClientInformationType) event.getObject());
        selectedClientInfoType = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ClientInformationType info = (ClientInformationType) event.getObject();
        if (info.getId() == null) {
            clientInformationTypeList.remove(info);
            selectedClientInfoType = null;
        }
    }
}

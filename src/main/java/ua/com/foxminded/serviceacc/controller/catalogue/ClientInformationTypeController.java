package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

@Named
@ApplicationScoped
public class ClientInformationTypeController implements Serializable {

    private static final long serialVersionUID = 1L;

    private ClientInformationType selectedClientInfoType;

    private List<ClientInformationType> clientInformationTypeList;

    private final ClientInformationTypeService clientInformationTypeService;

    @Inject
    public ClientInformationTypeController(ClientInformationTypeService cltService) {
        this.clientInformationTypeService = cltService;
    }

    @PostConstruct
    public void init() {
        clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public void add() {
        selectedClientInfoType = new ClientInformationType("", "");
        clientInformationTypeList.add(selectedClientInfoType);
    }

    public void delete() {
        clientInformationTypeService.delete(selectedClientInfoType.getId());
        clientInformationTypeList.remove(selectedClientInfoType);
        selectedClientInfoType = null;
    }

    public void onRowEdit(RowEditEvent event) {
        clientInformationTypeService.save((ClientInformationType) event.getObject());
        selectedClientInfoType = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ClientInformationType info = (ClientInformationType) event.getObject();
        if (info.getId() == null) {
            clientInformationTypeList.remove(info);
            selectedClientInfoType = null;
        }
    }

    //Getters and Setters

    public List<ClientInformationType> getClientInformationTypeList() {
        return clientInformationTypeList;
    }

    public ClientInformationType getSelectedClientInfoType() {
        return selectedClientInfoType;
    }

    public void setSelectedClientInfoType(ClientInformationType selectedClientInfoType) {
        this.selectedClientInfoType = selectedClientInfoType;
    }
}

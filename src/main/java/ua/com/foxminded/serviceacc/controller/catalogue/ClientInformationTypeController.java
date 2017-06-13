package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import ua.com.foxminded.serviceacc.model.ClientInformationType;

@Named
@ViewScoped
public class ClientInformationTypeController implements Serializable {

    private static final long serialVersionUID = 1L;

    private ClientInformationType selectedClientInfoType;
    private List<ClientInformationType> clientInformationTypeList;

    private ClientInfoTypeHolderBean typeHolder;

    @Inject
    public ClientInformationTypeController(ClientInfoTypeHolderBean typeHolder) {
        this.typeHolder = typeHolder;
    }

    @PostConstruct
    public void init() {
        clientInformationTypeList = typeHolder.getClientInformationTypeList();
    }

    public void add() {
        selectedClientInfoType = new ClientInformationType("", "");
        clientInformationTypeList.add(selectedClientInfoType);
    }

    public void delete() {
        typeHolder.delete(selectedClientInfoType);
        clientInformationTypeList.remove(selectedClientInfoType);
        selectedClientInfoType = null;
    }

    public void onRowEdit(RowEditEvent event) {
        typeHolder.save((ClientInformationType) event.getObject());
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

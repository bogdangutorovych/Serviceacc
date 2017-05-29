package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

@Named
@javax.faces.view.ViewScoped
public class ClientInformationTypeController implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(ClientInformationTypeController.class);

    private ClientInformationType selected;

    private static List<ClientInformationType> clientInformationTypeList;

    private ClientInformationTypeService clientInformationTypeService;
    private ConfigController configController;

    @PostConstruct
    public void inits() {
        log.info("==========creation ClientInformationTypeController ========================");
    }

    @PreDestroy
    public void kill() {
        log.info("======================= KILL ClientInformationTypeController ============================");
    }

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

    public ClientInformationType getSelected() {
        return selected;
    }

    public void setSelected(ClientInformationType selected) {
        this.selected = selected;
    }

    public void add() {
        selected = new ClientInformationType("", "");
        clientInformationTypeList.add(selected);
    }

    public void delete() {
        configController.deleteClientInformationType(selected.getId());
        clientInformationTypeList.remove(selected);
        selected = null;
    }

    public void onRowEdit(RowEditEvent event) {
        configController.saveClientInformationType((ClientInformationType) event.getObject());
        selected = null;
    }

    public void onRowCancel(RowEditEvent event) {
        ClientInformationType info = (ClientInformationType) event.getObject();
        if (info.getId() == null) {
            clientInformationTypeList.remove(info);
            selected = null;
        }
    }
}

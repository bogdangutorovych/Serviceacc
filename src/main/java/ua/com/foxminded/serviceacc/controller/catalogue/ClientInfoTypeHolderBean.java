package ua.com.foxminded.serviceacc.controller.catalogue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by andreb on 13.06.17.
 */
@Named
@ApplicationScoped
public class ClientInfoTypeHolderBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private List<ClientInformationType> clientInformationTypeList;
    final ClientInformationTypeService clientInformationTypeService;

    @Inject
    public ClientInfoTypeHolderBean(ClientInformationTypeService clientInformationTypeService) {
        this.clientInformationTypeService = clientInformationTypeService;
    }

    @PostConstruct
    public void init() {
        clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public List<ClientInformationType> getClientInformationTypeList() {
        return clientInformationTypeList;
    }

    public void setClientInformationTypeList(List<ClientInformationType> newClientTypeListType) {
        for (ClientInformationType type : newClientTypeListType) {
            clientInformationTypeService.save(type);
        }
        this.clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public ClientInformationType save(ClientInformationType type) {
        clientInformationTypeService.save(type);
        clientInformationTypeList = clientInformationTypeService.findAll();
        return type;
    }

    public void delete(ClientInformationType type) {
        clientInformationTypeService.delete(type);
        clientInformationTypeList = clientInformationTypeService.findAll();
    }
}

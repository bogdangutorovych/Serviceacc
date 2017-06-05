package ua.com.foxminded.serviceacc.controller.catalogue;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

/**
 * Created by andreb on 08.05.17. For holding information all time application
 * is up
 *
 */
@Named
@ApplicationScoped
public class ClientInfoTypeHolderBean {

    final ClientInformationTypeService clientInformationTypeService;

    private List<ClientInformationType> clientInformationTypeList;

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

    public ClientInformationType saveClientInformationType(ClientInformationType type) {

        clientInformationTypeService.save(type);
        clientInformationTypeList = clientInformationTypeService.findAll();

        return type;
    }

    public void deleteClientInformationType(Long typeId) {
        clientInformationTypeService.delete(typeId);
        clientInformationTypeList = clientInformationTypeService.findAll();
    }

}

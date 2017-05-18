package ua.com.foxminded.serviceacc.controller.catalogue;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.context.annotation.ApplicationScope;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

/**
 * Created by andreb on 08.05.17.
 * For holding information all time application is up
 *
 */
@Named
@ManagedBean
@ApplicationScope
public class ConfigController {

    @Inject
    ClientInformationTypeService clientInformationTypeService;

    private List<ClientInformationType> clientInformationTypeList;

    @PostConstruct
    public void init() {
        clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public List<ClientInformationType> getClientInformationTypeList(){
        return clientInformationTypeList;
    }

    public void setClientInformationTypeList(List<ClientInformationType> newClientTypeListType){
        for(ClientInformationType type : newClientTypeListType){
                clientInformationTypeService.saveOrUpdate(type);
        }

        this.clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public ClientInformationType saveClientInformationType(ClientInformationType type){

        clientInformationTypeService.saveOrUpdate(type);
        clientInformationTypeList = clientInformationTypeService.findAll();
        return type;
    }

    public ClientInformationType updateClientInformationType(ClientInformationType forUpdateType){

        clientInformationTypeService.saveOrUpdate(forUpdateType);
        clientInformationTypeList = clientInformationTypeService.findAll();
        return forUpdateType;
    }

    public void deleteClientInformationType(Long typeId){
        clientInformationTypeService.delete(typeId);
        clientInformationTypeList = clientInformationTypeService.findAll();
    }


}

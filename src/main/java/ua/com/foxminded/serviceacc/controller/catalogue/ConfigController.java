package ua.com.foxminded.serviceacc.controller.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.ApplicationScope;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.List;

/**
 * Created by andreb on 08.05.17.
 * For holding information all time application is up
 *
 */
@Controller
@ManagedBean
@ApplicationScope
public class ConfigController {

    @Autowired
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
            if (type.getId() == null){
                clientInformationTypeService.save(type);
            }else{
                clientInformationTypeService.update(type);
            }
        }

        this.clientInformationTypeList = clientInformationTypeService.findAll();
    }

    public ClientInformationType saveClientInformationType(ClientInformationType type){

        clientInformationTypeService.save(type);
        clientInformationTypeList = clientInformationTypeService.findAll();
        return type;
    }

    public ClientInformationType updateClientInformationType(ClientInformationType forUpdateType){

        clientInformationTypeService.update(forUpdateType);
        clientInformationTypeList = clientInformationTypeService.findAll();
        return forUpdateType;
    }

    public void deleteClientInformationType(Long typeId){
        clientInformationTypeService.delete(typeId);
        clientInformationTypeList = clientInformationTypeService.findAll();
    }


}

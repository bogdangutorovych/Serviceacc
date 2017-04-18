package ua.com.foxminded.serviceacc.service;

import ua.com.foxminded.serviceacc.model.ClientInformationType;

import java.util.List;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientInformationTypeService {

    ClientInformationType save(ClientInformationType clientInformationType);
    ClientInformationType update(ClientInformationType clientInformationType);
    ClientInformationType findById(Long contactTypeId);
    ClientInformationType findByTypeName(String contactTypeName);
    List<ClientInformationType> findAll();
    void delete(Long contactTypeId);
}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;

public interface ClientInformationService {
    
    ClientInformation save(ClientInformation clientInformation);

    ClientInformation update(ClientInformation clientInformation);

    ClientInformation findById(Long clientInformationId);

    List<ClientInformation> findAll();
    
    List<ClientInformation> findByClient(Client client);

    void delete(Long clientInformationId);
}

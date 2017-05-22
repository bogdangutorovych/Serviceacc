package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.repository.ClientInformationRepository;

@Service("clientInformationService")
public class ClientInformationServiceDataJpa implements ClientInformationService {

    @Autowired
    ClientInformationRepository clientInformationRepository;

    @Override
    public ClientInformation save(ClientInformation clientInformation) {
        return clientInformationRepository.save(clientInformation);
    }

    @Override
    public ClientInformation findById(Long clientInformationId) {
        return clientInformationRepository.findOne(clientInformationId);
    }

    @Override
    public List<ClientInformation> findAll() {
        return clientInformationRepository.findAll();
    }

    @Override
    public void delete(Long clientInformationId) {
        clientInformationRepository.delete(clientInformationId);
    }

    @Override
    public List<ClientInformation> findByClient(Client client) {
        return clientInformationRepository.findByClient(client);
    }

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.repository.ClientInformationRepository;

/** Created by Grischenko Maxim on 22.04.17. */

@Service("clientInformationService")
public class ClientInformationServiceDataJpa  implements ClientInformationService {

    private final ClientInformationRepository clientInfoTypeRepository;
    @Autowired
    public ClientInformationServiceDataJpa(ClientInformationRepository clientInfoTypeRepository) {
        this.clientInfoTypeRepository = clientInfoTypeRepository;
    }

    @Override
    public ClientInformation save(ClientInformation clientInformation) {
        return clientInfoTypeRepository.save(clientInformation);
    }

    @Override
    public ClientInformation update(ClientInformation clientInformation) {
        return clientInfoTypeRepository.save(clientInformation);
    }

    @Override
    public ClientInformation findById(Long contactTypeId) {
        return clientInfoTypeRepository.findOne(contactTypeId);
    }

    @Override
    public List<ClientInformation> findAll() {
        return clientInfoTypeRepository.findAll();
    }

    @Override
    public void delete(Long contactTypeId) {
        clientInfoTypeRepository.delete(contactTypeId);
    }
}

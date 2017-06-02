package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.repository.ClientInformationTypeRepository;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

/**
 * Created by andreb on 04.04.17.
 */
@Service("clientInformationTypeService")
public class ClientInformationTypeServiceDataJpa implements ClientInformationTypeService {

    @Autowired
    ClientInformationTypeRepository clientInfoTypeRepository;

    @Override
    public ClientInformationType save(ClientInformationType clientInformationType) {
        return clientInfoTypeRepository.save(clientInformationType);
    }

    @Override
    public ClientInformationType findById(Long contactTypeId) {
        return clientInfoTypeRepository.findOne(contactTypeId);
    }

    @Override
    public List<ClientInformationType> findAll() {
        return clientInfoTypeRepository.findAll();
    }

    @Override
    public void delete(Long contactTypeId) {
        clientInfoTypeRepository.delete(contactTypeId);
    }
}
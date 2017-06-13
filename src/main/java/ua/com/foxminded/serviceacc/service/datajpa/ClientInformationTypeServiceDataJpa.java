package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.ClientInformation;
import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.repository.ClientInformationTypeRepository;
import ua.com.foxminded.serviceacc.repository.ClientRepository;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

/**
 * Created by andreb on 04.04.17.
 */
@Service("clientInformationTypeService")
public class ClientInformationTypeServiceDataJpa implements ClientInformationTypeService {

    @Autowired
    ClientInformationTypeRepository clientInfoTypeRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public ClientInformationType save(ClientInformationType clientInformationType) {

        if (clientInformationType.getId() != null){
            return clientInfoTypeRepository.save(clientInformationType);
        }else{
            ClientInformationType persisted = clientInfoTypeRepository.save(clientInformationType);
            for (Client client : clientRepository.findAll()){
                ClientInformation info = new ClientInformation();
                info.setClientInformationType(persisted);
                info.setClient(client);
                client.getInformation().add(info);
                clientRepository.save(client);
            }
            return persisted;
        }

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

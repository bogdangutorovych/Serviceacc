package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.repository.ClientRepository;
import ua.com.foxminded.serviceacc.service.ClientService;

/**
 * Created by andreb on 31.03.17.
 */
@Service("clientService")
public class ClientServiceDataJpa implements ClientService {

	private final ClientRepository clientRepository;

	@Autowired
    public ClientServiceDataJpa(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findById(Long clientId) {
		return clientRepository.findOne(clientId);
	}

    @Override
    public Client findByIdWithClientInformation(Long clientId) {
        return clientRepository.findOneWithClientInformation(clientId);
    }

    @Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAllByOrderByIdAsc();
	}
}

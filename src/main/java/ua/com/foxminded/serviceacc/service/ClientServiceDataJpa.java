package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.repository.ClientRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("clientService")
public class ClientServiceDataJpa implements ClientService {

    @Autowired
	ClientRepository clientRepository;

	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client update(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public Client findById(Long clientId) {
		return clientRepository.findOne(clientId);
	}

	@Override
	public void delete(Long clientId) {
		clientRepository.delete(clientId);
	}

	@Override
	public List<Client> findAll() {
		return clientRepository.findAllByOrderByIdAsc();
	}
}

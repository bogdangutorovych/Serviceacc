package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Client;

/**
 * Created by andreb on 31.03.17.
 */
public interface ClientService {

	Client save(Client client);

	Client findById(Long clientId);

	Client findByIdWithClientInformation(Long clientId);

	List<Client> findAll();

	void delete(Long clientId);
}

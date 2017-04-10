package ua.com.foxminded.serviceacc.service;

import static java.lang.Math.toIntExact;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;

/**
 * Created by andreb on 31.03.17.
 */
@Service("clientService")
public class ClientServiceDataJpa implements ClientService {
	private List<Client> clients = new ArrayList<>();

	public ClientServiceDataJpa(){
		Client client = new Client();	
		client.setId(1L);
		clients.add(client);
		client = new Client();	
		client.setId(2L);
		clients.add(client);
		client = new Client();	
		client.setId(3L);
		clients.add(client);
	}

	//@Autowired
	//ClientRepository clientRepository;

	@Override
	public Client create(Client client) {
		//return clientRepository.save(client);		
		clients.add(client);		
		return client;
	}

	@Override
	public Client update(Client client) {
		//return clientRepository.save(client);
		if (clients.contains(client)) {
			System.out.println(client.getId());
			int id = toIntExact(client.getId());
			clients.set(id, client);
		} else {
			create(client);
		}
		return client;
	}

	@Override
	public Client findById(Long clientId) {
		//return clientRepository.findOne(clientId);
		return clients.stream().filter(t -> t.getId().equals(clientId)).findFirst().get();
	}

	@Override 	public List<Client> findAll() { 
		//return clientRepository.findAllAndFetchPersonEagly();
		return clients;	
	}

	@Override
	public void delete(Long clientId) {
		//clientRepository.delete(clientId);
		int id = toIntExact(clientId);
		clients.remove(id);		
		System.out.println(clients.size());
		
	}
}

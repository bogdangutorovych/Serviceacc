package ua.com.foxminded.serviceacc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.repository.ClientStatusTypeRepository;

/**
 * Created by andreb on 04.04.17.
 */
@Service("clientStatusTypeService")
public class ClientStatusTypeServiceDataJpa implements ClientStatusTypeService {
	private List<ClientStatusType> statuses = new ArrayList<>();

	public ClientStatusTypeServiceDataJpa(){
		ClientStatusType status = new ClientStatusType("code1","active");	
		statuses.add(status);
		status = new ClientStatusType("code2","frozen");
		statuses.add(status);
	}


	@Autowired
	ClientStatusTypeRepository clientStatusTypeRepository;

	@Override
	public ClientStatusType save(ClientStatusType clientStatusType) {
		return clientStatusTypeRepository.save(clientStatusType);
	}

	@Override
	public ClientStatusType update(ClientStatusType clientStatusType) {
		return clientStatusTypeRepository.save(clientStatusType);
	}

	@Override
	public ClientStatusType findById(Long clientStatusTypeId) {
		return clientStatusTypeRepository.findOne(clientStatusTypeId);
	}

	@Override
	public ClientStatusType findByStatusName(String statusName) {
		return clientStatusTypeRepository.findOneByTitle(statusName);
	}

	@Override
	public List<ClientStatusType> findAll() {
		//return clientStatusTypeRepository.findAll();
		return statuses;
	}

	@Override
	public void delete(Long clientStatusTypeId) {
		clientStatusTypeRepository.delete(clientStatusTypeId);
	}
}

package ua.com.foxminded.serviceacc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.repository.ClientLevelTypeRepository;

/**
 * Created by andreb on 04.04.17.
 */
@Service("clientLevelTypeService")
public class ClientLevelTypeServiceDataJpa implements ClientLevelTypeService {
	private List<ClientLevelType> levels = new ArrayList<>();

	public ClientLevelTypeServiceDataJpa(){
		ClientLevelType level = new ClientLevelType("code1","applicant");	
		levels.add(level);
		level = new ClientLevelType("code2","begginer");
		levels.add(level);
	}
	
	
	
    @Autowired
    ClientLevelTypeRepository clientLevelTypeRepository;

    @Override
    public ClientLevelType save(ClientLevelType clientLevelType) {
        return clientLevelTypeRepository.save(clientLevelType);
    }

    @Override
    public ClientLevelType update(ClientLevelType clientLevelType) {
        return clientLevelTypeRepository.save(clientLevelType);
    }

    @Override
    public ClientLevelType findById(Long clientLevelTypeId) {
        return clientLevelTypeRepository.findOne(clientLevelTypeId);
    }

    @Override
    public ClientLevelType findByLevelName(String levelName) {
        return clientLevelTypeRepository.findOneByLevel(levelName);
    }

    @Override
    public List<ClientLevelType> findAll() {
       // return clientLevelTypeRepository.findAll();
    	return levels;
    }

    @Override
    public void delete(Long clientLevelTypeId) {
        clientLevelTypeRepository.delete(clientLevelTypeId);
    }
}

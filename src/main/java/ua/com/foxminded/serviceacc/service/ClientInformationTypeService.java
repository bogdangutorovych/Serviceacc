package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ClientInformationType;

/**
 * Created by andreb on 04.04.17.
 */
public interface ClientInformationTypeService {

	ClientInformationType save(ClientInformationType clientInformationType);

	ClientInformationType update(ClientInformationType clientInformationType);

	ClientInformationType findById(Long clientInformationTypeId);

	ClientInformationType findByTypeName(String clientInformationTypeName);

	List<ClientInformationType> findAll();

	void delete(Long clientInformationTypeId);
}
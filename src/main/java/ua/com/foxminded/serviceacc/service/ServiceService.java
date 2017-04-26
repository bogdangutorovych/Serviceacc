package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Service;

public interface ServiceService {

	Service save(Service service);

	Service update(Service service);

	Service findById(Long serviceId);

	List<Service> findAll();

	void delete(Long serviceId);
}

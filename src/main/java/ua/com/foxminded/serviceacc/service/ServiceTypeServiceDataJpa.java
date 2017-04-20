package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ServiceType;
import ua.com.foxminded.serviceacc.repository.ServiceTypeRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("serviceTypeService")
public class ServiceTypeServiceDataJpa implements ServiceTypeService {

	@Autowired
	ServiceTypeRepository serviceTypeRepository;

	@Override
	public ServiceType save(ServiceType serviceType) {
		return serviceTypeRepository.save(serviceType);
	}

	@Override
	public ServiceType update(ServiceType serviceType) {
		return serviceTypeRepository.save(serviceType);
	}

	@Override
	public ServiceType findById(Long serviceTypeId) {
		return serviceTypeRepository.findOne(serviceTypeId);
	}

	@Override
	public void delete(Long serviceTypeId) {
		serviceTypeRepository.delete(serviceTypeId);
	}

	@Override
	public List<ServiceType> findAll() {
		return serviceTypeRepository.findAll();
	}
}

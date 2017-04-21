package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.ServiceType;

/**
 * Created by andreb on 31.03.17.
 */
public interface ServiceTypeService {

	ServiceType save(ServiceType serviceType);

	ServiceType update(ServiceType serviceType);

	ServiceType findById(Long serviceTypeId);

	List<ServiceType> findAll();

	void delete(Long serviceTypeId);
}

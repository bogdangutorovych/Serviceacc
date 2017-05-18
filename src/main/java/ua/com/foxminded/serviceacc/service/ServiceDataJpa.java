package ua.com.foxminded.serviceacc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.repository.ServiceRepository;

@Service("serviceService")
public class ServiceDataJpa implements ServiceService {

    @Inject
    ServiceRepository serviceRepository;

    @Override
    public ua.com.foxminded.serviceacc.model.Service save(ua.com.foxminded.serviceacc.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public ua.com.foxminded.serviceacc.model.Service update(ua.com.foxminded.serviceacc.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public ua.com.foxminded.serviceacc.model.Service findById(Long serviceId) {
        return serviceRepository.findOne(serviceId);
    }

    @Override
    public List<ua.com.foxminded.serviceacc.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void delete(Long serviceId) {
        serviceRepository.delete(serviceId);

    }

}

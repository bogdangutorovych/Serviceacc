package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.repository.ServiceRepository;
import ua.com.foxminded.serviceacc.service.ServiceService;

@Service("serviceService")
public class ServiceDataJpa implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public ua.com.foxminded.serviceacc.model.Service save(ua.com.foxminded.serviceacc.model.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public ua.com.foxminded.serviceacc.model.Service findById(Long serviceId) {
        return serviceRepository.findOne(serviceId);
    }

    @Override
    public List<ua.com.foxminded.serviceacc.model.Service> findAll() {
        return serviceRepository.findAllByOrderByIdAsc();
    }

    @Override
    public void delete(Long serviceId) {
        serviceRepository.delete(serviceId);

    }

}

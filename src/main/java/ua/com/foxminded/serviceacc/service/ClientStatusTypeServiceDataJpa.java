package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.ContractStatus;
import ua.com.foxminded.serviceacc.repository.ClientStatusTypeRepository;

/**
 * Created by andreb on 04.04.17.
 */
@Service("clientStatusTypeService")
public class ClientStatusTypeServiceDataJpa implements ClientStatusTypeService {

    @Autowired
    ClientStatusTypeRepository clientStatusTypeRepository;

    @Override
    public ContractStatus save(ContractStatus clientStatusType) {
        return clientStatusTypeRepository.save(clientStatusType);
    }

    @Override
    public ContractStatus update(ContractStatus clientStatusType) {
        return clientStatusTypeRepository.save(clientStatusType);
    }

    @Override
    public ContractStatus findById(Long clientStatusTypeId) {
        return clientStatusTypeRepository.findOne(clientStatusTypeId);
    }

    @Override
    public ContractStatus findByStatusName(String statusName) {
        return clientStatusTypeRepository.findOneByTitle(statusName);
    }

    @Override
    public List<ContractStatus> findAll() {
        return clientStatusTypeRepository.findAll();
    }

    @Override
    public void delete(Long clientStatusTypeId) {
        clientStatusTypeRepository.delete(clientStatusTypeId);
    }
}

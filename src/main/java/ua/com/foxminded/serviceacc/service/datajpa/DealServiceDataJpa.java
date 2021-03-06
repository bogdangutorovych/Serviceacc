package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.repository.DealRepository;
import ua.com.foxminded.serviceacc.service.DealService;

@Service("dealService")
public class DealServiceDataJpa implements DealService {

    @Autowired
    DealRepository dealRepository;

    @Override
    public Deal save(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public Deal findById(Long dealId) {
        return dealRepository.findOne(dealId);
    }

    @Override
    public List<Deal> findAll() {
        return dealRepository.findAll();
    }

    @Override
    public void delete(Long dealId) {
        dealRepository.delete(dealId);
    }

    @Override
    public List<Deal> findByClient(Client client) {
        return dealRepository.findByClient(client);
    }
}

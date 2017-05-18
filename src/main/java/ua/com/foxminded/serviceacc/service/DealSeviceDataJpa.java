package ua.com.foxminded.serviceacc.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.repository.DealRepository;

@Service("dealService")
public class DealSeviceDataJpa implements DealService {
    
    @Inject
    DealRepository dealRepository;

    @Override
    public Deal save(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public Deal update(Deal deal) {
        return dealRepository.save(deal);
    }

    @Override
    public Deal findById(Long DealId) {
        return dealRepository.findOne(DealId);
    }

    @Override
    public List<Deal> findAll() {
        return dealRepository.findAll();
    }

    @Override
    public void delete(Long DealId) {
        dealRepository.delete(DealId);
    }

    @Override
    public List<Deal> findByClient(Client client) {
        return dealRepository.findByClient(client);
    }

}

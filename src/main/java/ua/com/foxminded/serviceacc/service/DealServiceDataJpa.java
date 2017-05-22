package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.repository.DealRepository;

@Service("dealService")
public class DealServiceDataJpa implements DealService {

    @Autowired
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

}

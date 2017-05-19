package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.model.Deal;

public interface DealService {

    Deal save(Deal deal);

    Deal findById(Long DealId);

    List<Deal> findAll();

    List<Deal> findByClient(Client client);

    void delete(Long DealId);

}

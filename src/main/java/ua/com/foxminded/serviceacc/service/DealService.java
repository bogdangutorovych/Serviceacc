package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Deal;

public interface DealService {

    Deal save(Deal deal);

    Deal update(Deal deal);

    Deal findById(Long dealId);

    List<Deal> findAll();

    void delete(Long dealId);
}

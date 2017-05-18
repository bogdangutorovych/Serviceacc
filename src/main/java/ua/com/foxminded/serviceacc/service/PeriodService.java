package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Period;

public interface PeriodService {

    Period saveOrUpdate(Period period);

    Period findById(Long periodId);

    List<Period> findAll();

    void delete(Long periodId);
}

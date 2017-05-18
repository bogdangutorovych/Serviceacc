package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.repository.PeriodRepository;

@Service("periodService")
public class PeriodServiceDataJpa implements PeriodService {

    @Autowired
    PeriodRepository periodRepository;

    @Override
    public Period create(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public Period update(Period period) {
        return periodRepository.save(period);
    }

    @Override
    public Period findById(Long periodId) {
        return periodRepository.findOne(periodId);
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public void delete(Long periodId) {
        periodRepository.delete(periodId);

    }

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.repository.MoneyRepository;

@Service("moneyService")
public class MoneyServiceDataJpa implements MoneyService {

    @Autowired
    MoneyRepository moneyRepository;

    @Override
    public Money save(Money money) {
        return moneyRepository.save(money);
    }

    @Override
    public Money update(Money money) {
        return moneyRepository.save(money);
    }

    @Override
    public Money findById(Long moneyId) {
        return moneyRepository.findOne(moneyId);
    }

    @Override
    public List<Money> findAll() {
        return moneyRepository.findAll();
    }

    @Override
    public void delete(Long moneyId) {
        moneyRepository.delete(moneyId);

    }

}

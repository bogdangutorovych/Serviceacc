package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.repository.MoneyRepository;
import ua.com.foxminded.serviceacc.service.MoneyService;

@Service("moneyService")
public class MoneySeviceDataJpa implements MoneyService {

    @Autowired
    MoneyRepository moneyRepository;

    @Override
    public Money save(Money money) {
        return moneyRepository.save(money);
    }

    @Override
    public Money findById(Long MoneyId) {
        return moneyRepository.findOne(MoneyId);
    }

    @Override
    public List<Money> findAll() {
        return moneyRepository.findAll();
    }

    @Override
    public void delete(Long MoneyId) {
        moneyRepository.delete(MoneyId);
    }

}

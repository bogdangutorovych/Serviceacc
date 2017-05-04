package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.Money;

public interface MoneyService {

    Money save(Money money);

    Money update(Money money);

    Money findById(Long moneyId);

    List<Money> findAll();

    void delete(Long moneyId);
}

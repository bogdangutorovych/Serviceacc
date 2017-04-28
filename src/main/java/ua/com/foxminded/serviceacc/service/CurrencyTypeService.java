package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.CurrencyType;

public interface CurrencyTypeService {

    CurrencyType save(CurrencyType currencyType);

    CurrencyType update(CurrencyType currencyType);

    CurrencyType findById(Long currencyType);

    List<CurrencyType> findAll();

    void delete(Long currencyTypeId);
}

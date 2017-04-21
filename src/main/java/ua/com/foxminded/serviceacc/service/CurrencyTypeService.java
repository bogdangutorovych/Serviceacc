package ua.com.foxminded.serviceacc.service;

import java.util.List;
import ua.com.foxminded.serviceacc.model.CurrencyType;

public interface CurrencyTypeService {

	CurrencyType save(CurrencyType currencyType);

	CurrencyType update(CurrencyType currencyType);

	CurrencyType findById(Long currencyType);

	CurrencyType findByCurrentName(String currencyName);

	List<CurrencyType> findAll();

	void delete(Long currencyTypeId);
}

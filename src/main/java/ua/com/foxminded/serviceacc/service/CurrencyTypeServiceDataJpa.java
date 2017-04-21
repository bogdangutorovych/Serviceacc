package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.CurrencyType;
import ua.com.foxminded.serviceacc.repository.CurrencyTypeRepository;

@Service("currencyService")
public class CurrencyTypeServiceDataJpa implements CurrencyTypeService {

	@Autowired
	CurrencyTypeRepository currencyRepository;

	@Override
	public CurrencyType save(CurrencyType currencyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyType update(CurrencyType currencyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyType findById(Long currencyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrencyType findByCurrentName(String currencyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CurrencyType> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long currencyTypeId) {
		// TODO Auto-generated method stub

	}

}

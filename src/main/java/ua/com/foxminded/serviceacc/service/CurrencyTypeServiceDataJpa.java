package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.CurrencyType;
import ua.com.foxminded.serviceacc.repository.CurrencyTypeRepository;

@Service("currencyService")
public class CurrencyTypeServiceDataJpa implements CurrencyTypeService {

	@Autowired
	CurrencyTypeRepository currencyTypeRepository;

	@Override
	public CurrencyType save(CurrencyType currencyType) {
		return currencyTypeRepository.save(currencyType);
	}

	@Override
	public CurrencyType update(CurrencyType currencyType) {
		return currencyTypeRepository.save(currencyType);
	}

	@Override
	public CurrencyType findById(Long currencyType) {
		return currencyTypeRepository.findOne(currencyType);
	}

	@Override
	public CurrencyType findByCurrentName(String currencyName) {
		return currencyTypeRepository.findOneByTitle(currencyName);
	}

	@Override
	public List<CurrencyType> findAll() {
		return currencyTypeRepository.findAll();
	
	}

	@Override
	public void delete(Long currencyTypeId) {
		currencyTypeRepository.delete(currencyTypeId);
	}

}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.PaymentType;
import ua.com.foxminded.serviceacc.repository.PaymentTypeRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("serviceTypeService")
public class ServiceTypeServiceDataJpa implements PaymentTypeService {

	@Autowired
	PaymentTypeRepository paymentTypeRepository;

	@Override
	public PaymentType save(PaymentType paymentType) {
		return paymentTypeRepository.save(paymentType);
	}

	@Override
	public PaymentType update(PaymentType paymentType) {
		return paymentTypeRepository.save(paymentType);
	}

	@Override
	public PaymentType findById(Long paymentTypeId) {
		return paymentTypeRepository.findOne(paymentTypeId);
	}

	@Override
	public void delete(Long paymentTypeId) {
		paymentTypeRepository.delete(paymentTypeId);
	}

	@Override
	public List<PaymentType> findAll() {
		return paymentTypeRepository.findAll();
	}
}

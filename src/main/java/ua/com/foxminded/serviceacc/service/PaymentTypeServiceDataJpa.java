package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.PaymentType;
import ua.com.foxminded.serviceacc.repository.PaymentTypeRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("paymentTypeService")
public class PaymentTypeServiceDataJpa implements PaymentTypeService {

	@Autowired
    PaymentTypeRepository serviceTypeRepository;

	@Override
	public PaymentType save(PaymentType paymentType) {
		return serviceTypeRepository.save(paymentType);
	}

	@Override
	public PaymentType update(PaymentType paymentType) {
		return serviceTypeRepository.save(paymentType);
	}

	@Override
	public PaymentType findById(Long paymentTypeId) {
		return serviceTypeRepository.findOne(paymentTypeId);
	}

	@Override
	public void delete(Long paymentTypeId) {
		serviceTypeRepository.delete(paymentTypeId);
	}

	@Override
	public List<PaymentType> findAll() {
		return serviceTypeRepository.findAll();
	}
}

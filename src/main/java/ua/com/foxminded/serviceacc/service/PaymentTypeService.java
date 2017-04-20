package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.PaymentType;

/**
 * Created by andreb on 31.03.17.
 */
public interface PaymentTypeService {

	PaymentType save(PaymentType paymentType);

	PaymentType update(PaymentType paymentType);

	PaymentType findById(Long paymentTypeId);

	List<PaymentType> findAll();

	void delete(Long paymentTypeId);
}

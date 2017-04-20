package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.PayStatus;
import ua.com.foxminded.serviceacc.repository.PayStatusRepository;

/**
 * Created by andreb on 31.03.17.
 */
@Service("payStatusService")
public class PayStatusServiceDataJpa implements PayStatusService {

	@Autowired
	PayStatusRepository payStatusRepository;

	@Override
	public PayStatus save(PayStatus payStatus) {
		return payStatusRepository.save(payStatus);
	}

	@Override
	public PayStatus update(PayStatus payStatus) {
		return payStatusRepository.save(payStatus);
	}

	@Override
	public PayStatus findById(Long payStatusId) {
		return payStatusRepository.findOne(payStatusId);
	}

	@Override
	public void delete(Long payStatusId) {
		payStatusRepository.delete(payStatusId);
	}

	@Override
	public List<PayStatus> findAll() {
		return payStatusRepository.findAll();
	}
}

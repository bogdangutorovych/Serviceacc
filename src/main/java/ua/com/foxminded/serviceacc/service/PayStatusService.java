package ua.com.foxminded.serviceacc.service;

import java.util.List;

import ua.com.foxminded.serviceacc.model.PayStatus;

/**
 * Created by andreb on 31.03.17.
 */
public interface PayStatusService {

	PayStatus save(PayStatus payStatus);

	PayStatus update(PayStatus payStatus);

	PayStatus findById(Long payStatusId);

	List<PayStatus> findAll();

	void delete(Long payStatusId);
}

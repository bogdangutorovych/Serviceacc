package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.PaymentType;
import ua.com.foxminded.serviceacc.service.PaymentTypeService;

@Controller
@ManagedBean
@ViewScoped
public class PaymentTypeController implements Serializable {
	private static final long serialVersionUID = 1L;

	private PaymentType selected;

	private static List<PaymentType> paymentTypeList;

	private PaymentTypeService paymentTypeService;

	@Autowired
	public PaymentTypeController(PaymentTypeService paymentTypeService) {
		this.paymentTypeService = paymentTypeService;
	}

	@PostConstruct
	public void init() {
		paymentTypeList = paymentTypeService.findAll();
	}

	public PaymentTypeService getPaymentTypeService() {
		return paymentTypeService;
	}

	public List<PaymentType> getPaymentTypeList() {
		return paymentTypeList;
	}

	public PaymentType getSelected() {
		return selected;
	}

	public void setSelected(PaymentType selected) {
		this.selected = selected;
	}

	public void add() {
		selected = new PaymentType("", "");
		paymentTypeList.add(selected);
	}

	public void delete() {
		paymentTypeList.remove(selected);
		paymentTypeService.delete(selected.getId());
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		paymentTypeService.save((PaymentType) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		PaymentType status = (PaymentType) event.getObject();
		if (status.getId() == null) {
			paymentTypeList.remove(status);
			selected = null;
		}
	}

}
package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.PayStatus;
import ua.com.foxminded.serviceacc.service.PayStatusService;

@Controller
@ManagedBean
@ViewScoped
public class PayStatusController implements Serializable {
	private static final long serialVersionUID = 1L;

	private PayStatus selected;

	private static List<PayStatus> payStatusList;

	private PayStatusService paymentTypeService;

	@Autowired
	public PayStatusController(PayStatusService paymentTypeService) {
		this.paymentTypeService = paymentTypeService;
	}

	@PostConstruct
	public void init() {
		payStatusList = paymentTypeService.findAll();
	}

	public PayStatusService getPayStatusService() {
		return paymentTypeService;
	}

	public List<PayStatus> getPayStatusList() {
		return payStatusList;
	}

	public PayStatus getSelected() {
		return selected;
	}

	public void setSelected(PayStatus selected) {
		this.selected = selected;
	}

	public void add() {
		selected = new PayStatus("", "");
		payStatusList.add(selected);
	}

	public void delete() {
		paymentTypeService.delete(selected.getId());
        payStatusList.remove(selected);
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		paymentTypeService.save((PayStatus) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		PayStatus status = (PayStatus) event.getObject();
		if (status.getId() == null) {
			payStatusList.remove(status);
			selected = null;
		}
	}

}

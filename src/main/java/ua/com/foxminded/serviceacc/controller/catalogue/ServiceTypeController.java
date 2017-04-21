package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.ServiceType;
import ua.com.foxminded.serviceacc.service.ServiceTypeService;

@Controller
@ManagedBean
@ViewScoped
public class ServiceTypeController implements Serializable {
	private static final long serialVersionUID = 1L;

	private ServiceType selected;

	private static List<ServiceType> serviceTypeList;

	private ServiceTypeService serviceTypeService;

	@Autowired
	public ServiceTypeController(ServiceTypeService cstService) {
		this.serviceTypeService = cstService;
	}

	@PostConstruct
	public void init() {
		serviceTypeList = serviceTypeService.findAll();
	}

	public ServiceTypeService getServiceTypeService() {
		return serviceTypeService;
	}

	public List<ServiceType> getServiceTypeList() {
		return serviceTypeList;
	}

	public ServiceType getSelected() {
		return selected;
	}

	public void setSelected(ServiceType selected) {
		this.selected = selected;
	}

	public void add() {
		selected = new ServiceType("", "");
		serviceTypeList.add(selected);
	}

	public void delete() {
		serviceTypeList.remove(selected);
		serviceTypeService.delete(selected.getId());
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		serviceTypeService.save((ServiceType) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		ServiceType status = (ServiceType) event.getObject();
		if (status.getId() == null) {
			serviceTypeList.remove(status);
			selected = null;
		}
	}

}
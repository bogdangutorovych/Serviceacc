package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.controller.client.ClientController;
import ua.com.foxminded.serviceacc.model.ClientStatusType;
import ua.com.foxminded.serviceacc.service.ClientStatusTypeService;

@Controller
@SessionScoped
@ManagedBean
public class ClientStatusTypeController implements Serializable {
	private static final long serialVersionUID = 1L;

	private static boolean isShowForm = false;

	private ClientStatusType selected;

	private static List<ClientStatusType> statusList;

	public boolean getIsShowForm() {
		return isShowForm;
	}

	public void setIsShowForm(boolean isShowForm) {
		this.isShowForm = isShowForm;
	}

	private ClientStatusTypeService cstService;
	@Autowired
	public ClientStatusTypeController(ClientStatusTypeService cstService) {
		this.cstService = cstService;
	}

	@PostConstruct
	public void init() {
		statusList = cstService.findAll();
	}

	public List<ClientStatusType> getStatusList() {
		return statusList;
	}

	public ClientStatusType getSelected() {
		return selected;
	}

	public void setSelected(ClientStatusType selected) {
		this.selected = selected;
	}

	public void setService(ClientStatusTypeService service) {
		this.cstService = service;
	}

	public void add() {
		ClientStatusType newStatus = new ClientStatusType("","");
		statusList.add(newStatus);
	}

	public void delete(ClientStatusType status) {
		statusList.remove(status);
		cstService.delete(status.getId());
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		cstService.save((ClientStatusType) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		ClientStatusType status = (ClientStatusType) event.getObject();
		if(status.getId()==null) {
			statusList.remove(status);
		}
		selected = null;
	}

	public void showForm() {
		setIsShowForm(true);
		statusList = cstService.findAll();
	}

	public void hideForm() {
		setIsShowForm(false);
	}

}

package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.ClientInformationType;
import ua.com.foxminded.serviceacc.service.ClientInformationTypeService;

@Controller
@ManagedBean
@ViewScoped
public class ClientInformationTypeController implements Serializable {
	private static final long serialVersionUID = 1L;

	private ClientInformationType selected;

	private static List<ClientInformationType> clientInformationTypeList;

	private ClientInformationTypeService clientInformationTypeService;

    @Autowired
    private ConfigController configController;

	@Autowired
	public ClientInformationTypeController(ClientInformationTypeService cltService) {
		this.clientInformationTypeService = cltService;
	}

	@PostConstruct
	public void init() {
		clientInformationTypeList = configController.getClientInformationTypeList();
	}

	public ClientInformationTypeService getClientInformationTypeService() {
		return clientInformationTypeService;
	}

	public List<ClientInformationType> getClientInformationTypeList() {
		return clientInformationTypeList;
	}

	public ClientInformationType getSelected() {
		return selected;
	}

	public void setSelected(ClientInformationType selected) {
		this.selected = selected;
	}

	public void add() {
		selected = new ClientInformationType("", "");
		clientInformationTypeList.add(selected);
	}

	public void delete() {
        configController.deleteClientInformationType(selected.getId());
        clientInformationTypeList.remove(selected);
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		configController.saveClientInformationType((ClientInformationType) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		ClientInformationType info = (ClientInformationType) event.getObject();
		if (info.getId() == null) {
			clientInformationTypeList.remove(info);
			selected = null;
		}
	}
}

package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Controller
@ViewScoped
@ManagedBean
public class ClientListController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static List<Client> list;

	private Client selected;

	private final ClientService clientService;
	@Autowired
	public ClientListController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostConstruct
	public void init() {
		list = clientService.findAll();
	}

	public List<Client> getList() {
		return list;
	}

	public Client getSelected() {
		return selected;
	}

	public void setSelected(Client selected) {
		this.selected = selected;
	}

	public void delete() {
		list.remove(selected);
		clientService.delete(selected.getId());
		selected = null;
	}
}

package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@Controller
@ViewScoped
@ManagedBean
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Client selectedClient;

	private final ClientService clientService;
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostConstruct
	public void init() {
		selectedClient = new Client();
	}

	public void onOk() {
		clientService.update(selectedClient);
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}
}

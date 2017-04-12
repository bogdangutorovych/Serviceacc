package ua.com.foxminded.serviceacc.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@Controller
@SessionScoped
@ManagedBean
public class ClientList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list = new ArrayList<>();

	private boolean show;

	@Autowired
	private ClientService clientService;

	@PostConstruct
	public void init() {
		updateData();
		show();
	}

	public void updateData() {
		list = (ArrayList<Client>) clientService.findAll();
	}

	public void show() {
		show = true;
	}

	public void hide() {
		show = false;
	}

	public ArrayList<Client> getList() {
		return this.list;
	}

	public boolean isShow() {
		return this.show;
	}

	public ClientService getClientService() {
		return this.clientService;
	}

	public void setList(ArrayList<Client> list) {
		this.list = list;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}

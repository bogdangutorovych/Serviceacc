package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;
import ua.com.foxminded.serviceacc.service.PersonService;

@Component
@ViewScoped
public class ClientList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list;

	private boolean isShowClients = false;

	private boolean isBlockTable;

	@Autowired
	private ClientService clientService;

	@Autowired
	private PersonService personService;

	@PostConstruct
	public void init() {
		updateData();
	}

	public void updateData() {
		list = (ArrayList<Client>) clientService.findAll();

	}

	public boolean getIsShowClients() {
		return isShowClients;
	}

	public void setIsShowClients(boolean isShowClients) {
		this.isShowClients = isShowClients;
	}

	public boolean getIsBlockTable() {
		return isBlockTable;
	}

	public void setIsBlockTable(boolean isBlockTable) {
		this.isBlockTable = isBlockTable;
	}

	public void show() {
		isShowClients = true;
	}

	public void hide() {
		isShowClients = false;
	}

	public void block() {
		isBlockTable = false;

	}

	public void unBlock() {
		isBlockTable = true;

	}

	public ArrayList<Client> getList() {
		return list;
	}

	public void setList(ArrayList<Client> list) {
		this.list = list;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
}

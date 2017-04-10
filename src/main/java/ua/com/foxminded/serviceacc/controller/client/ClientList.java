package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;


@Named
public class ClientList implements Serializable {

	public ArrayList<Client> getList() {
		return list;
	}

	public void setList(ArrayList<Client> list) {
		this.list = list;
	}

	public boolean isClientsListShow() {
		return clientsListShow;
	}

	public void setClientsListShow(boolean clientsListShow) {
		this.clientsListShow = clientsListShow;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list = new ArrayList<>();	

	private boolean clientsListShow;	

	@Inject
	private ClientService clientService;
	
	@PostConstruct
	public void init() {
		updateData();
		show();
	}

	public void updateData() {
		list = 	(ArrayList<Client>) clientService.findAll();		
	}
	
	public void show() {
		clientsListShow = true;
	}

	public void hide() {
		clientsListShow = false;
	}

}

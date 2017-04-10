package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

@Named
@Getter
@Setter
public class ClientList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list = new ArrayList<>();

	private boolean show;

	@Inject
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
}

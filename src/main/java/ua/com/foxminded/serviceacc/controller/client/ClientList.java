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
import ua.com.foxminded.serviceacc.service.PersonService;

@Named
@Getter @Setter
public class ClientList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list;

	private boolean show = false;	

	@Inject
	private ClientService clientService;

	@Inject
	private PersonService personService;

	@PostConstruct
	public void init() {
		updateData();
	}

	public void updateData() {
		list = new ArrayList<>();		
		Client client = new Client();
		client.setId(1L);	
		list.add(client);	
	}
	
	public void show() {
		show = true;
	}

	public void hide() {
		show = false;
	}

}

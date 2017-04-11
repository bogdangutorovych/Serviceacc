package ua.com.foxminded.serviceacc.controller.client;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ua.com.foxminded.serviceacc.model.Client;
import ua.com.foxminded.serviceacc.service.ClientService;

@Component
//@Named
@Getter
@Setter
//@SessionScoped
@Scope("view")
//@ManagedBean(name = "clientsList")
public class ClientList implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Client> list = new ArrayList<>();

	private boolean show;

	@Autowired
//	@ManagedProperty(value = "#{clientService}")
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

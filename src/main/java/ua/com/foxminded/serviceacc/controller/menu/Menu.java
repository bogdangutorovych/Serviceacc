package ua.com.foxminded.serviceacc.controller.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Named
@Getter
@Setter
@SessionScoped
@ManagedBean(name = "menu")
public class Menu {

	@Inject
	@ManagedProperty(value = "#{clientController}")
	private ClientController clientController;

	@Inject
	@ManagedProperty(value = "#{clientStatusTypeController}")
	private ClientStatusTypeController clientStatusTypeController;

	public void menuOnMain() {
		System.out.println("menuOnMain");
		clientController.hide();
	}

	public void menuOnAll() {
		System.out.println("menuOnAll");
		clientController.show();
	}

}

package ua.com.foxminded.serviceacc.controller.menu;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.Getter;
import lombok.Setter;
import ua.com.foxminded.serviceacc.controller.catalogue.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Controller
@Getter
@Setter
@SessionScoped
@ManagedBean
public class Menu {

	@Autowired
	private ClientController clientController;

	@Autowired
	private ClientStatusTypeController clientStatusTypeController;

	public void menuOnMain() {
		// System.out.println("menuOnMain");
		clientController.hide();
		clientStatusTypeController.hideForm();
	}

	public void menuOnClients() {
		// System.out.println("menuOnAll");
		clientStatusTypeController.hideForm();
		clientController.show();

	}

	public void menuOnClientStatusTypes() {
		clientController.hide();
		clientStatusTypeController.showForm();
	}

}

package ua.com.foxminded.serviceacc.controller.menu;

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
import ua.com.foxminded.serviceacc.controller.ClientStatusTypeController;
import ua.com.foxminded.serviceacc.controller.client.ClientController;

@Component
//@Named
@Getter
@Setter
@Scope("view")
//@ManagedBean(name = "menu")
public class Menu {

	@Autowired
//	@ManagedProperty(value = "#{clientController}")
	private ClientController clientController;

	@Autowired
//	@ManagedProperty(value = "#{clientStatusTypeController}")
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

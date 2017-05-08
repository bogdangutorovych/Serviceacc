package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.ClientLevelType;
import ua.com.foxminded.serviceacc.service.ClientLevelTypeService;

@Controller
@ManagedBean
@ViewScoped
public class ClientLevelTypeController implements Serializable {
	private static final long serialVersionUID = 1L;

	private ClientLevelType selected;

	private static List<ClientLevelType> levelList;

	private ClientLevelTypeService cltService;

	@Autowired
	public ClientLevelTypeController(ClientLevelTypeService cltService) {
		this.cltService = cltService;
	}

	@PostConstruct
	public void init() {
		levelList = cltService.findAll();
	}

	public ClientLevelTypeService getCltService() {
		return cltService;
	}

	public List<ClientLevelType> getLevelList() {
		return levelList;
	}

	public ClientLevelType getSelected() {
		return selected;
	}

	public void setSelected(ClientLevelType selected) {
		this.selected = selected;
	}

	public void add() {
		selected = new ClientLevelType("", "");
		levelList.add(selected);
	}

	public void delete() {
		cltService.delete(selected.getId());
        levelList.remove(selected);
		selected = null;
	}

	public void onRowEdit(RowEditEvent event) {
		cltService.save((ClientLevelType) event.getObject());
		selected = null;
	}

	public void onRowCancel(RowEditEvent event) {
		ClientLevelType level = (ClientLevelType) event.getObject();
		if (level.getId() == null) {
			levelList.remove(level);
			selected = null;
		}
	}
}

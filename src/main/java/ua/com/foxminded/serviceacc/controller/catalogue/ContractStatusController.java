package ua.com.foxminded.serviceacc.controller.catalogue;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.ContractStatus;
import ua.com.foxminded.serviceacc.service.ContractStatusService;

@Controller
@ManagedBean
@ViewScoped
public class ContractStatusController implements Serializable {
	private static final long serialVersionUID = 1L;

	private ContractStatus contractStatus;

	private static List<ContractStatus> statusList;

	private ContractStatusService statusService;

	@Autowired
	public ContractStatusController(ContractStatusService statusService) {
		this.statusService = statusService;
	}

	@PostConstruct
	public void init() {
		statusList = statusService.findAll();
	}

	public ContractStatusService getStatusService() {
		return statusService;
	}

	public List<ContractStatus> getStatusList() {
		return statusList;
	}

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus selected) {
		this.contractStatus = selected;
	}

	public void add() {
		contractStatus = new ContractStatus("", "");
		statusList.add(contractStatus);
	}

	public void delete() {
		statusList.remove(contractStatus);
		statusService.delete(contractStatus.getId());
		contractStatus = null;
	}

	public void onRowEdit(RowEditEvent event) {
		statusService.save((ContractStatus) event.getObject());
		contractStatus = null;
	}

	public void onRowCancel(RowEditEvent event) {
		ContractStatus status = (ContractStatus) event.getObject();
		if (status.getId() == null) {
			statusList.remove(status);
			contractStatus = null;
		}
	}

}
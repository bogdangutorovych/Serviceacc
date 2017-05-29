package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Deal;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.service.ContractService;

@Named
@ViewScoped
public class ContractController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ContractController.class);
    private static final long serialVersionUID = 1L;

    private Contract selected;
    private ContractService contractService;

    @Inject
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    public void add(Deal deal) {
        selected = new Contract();
        selected.setDeal(deal);
        selected.setContractDate(LocalDate.now());
        selected.setClientRate(new Money());
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = contractService.save(selected);
            selected.setNumber("contr# " + selected.getId());
        }
        contractService.save(selected);
    }

    public void delete() {
        contractService.delete(selected.getId());
    }

    public void onCancel() {
        log.info("onCancel");
        selected = null;
    }

    public Contract getSelected() {
        return selected;
    }

    public void setSelected(Contract selected) {
        this.selected = selected;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

}

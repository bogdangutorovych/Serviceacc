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

    private static Logger logger = LoggerFactory.getLogger(ContractController.class);
    private static final long serialVersionUID = 1L;

    private Contract selectedContract;
    private final ContractService contractService;

    @Inject
    public ContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    public void add(Deal deal) {
        selectedContract = new Contract();
        selectedContract.setDeal(deal);
        selectedContract.setContractDate(LocalDate.now());
        selectedContract.setClientRate(new Money());
        //TODO: set manager Rate in view
        Money managerRate = new Money();
        managerRate.setAmount(deal.getService().getManagerRate().getAmount());
        managerRate.setCurrency(deal.getService().getManagerRate().getCurrency());
        selectedContract.setManagerRate(managerRate);
    }

    public void onOk() {
        if (selectedContract.getId() == null) {
            selectedContract = contractService.save(selectedContract);
            selectedContract.setNumber("contr# " + selectedContract.getId());
        }
        contractService.save(selectedContract);
    }

    public void delete() {
        contractService.delete(selectedContract.getId());
    }

    public void onCancel() {
        logger.info("onCancel");
        selectedContract = null;
    }

    public Contract getSelectedContract() {
        return selectedContract;
    }

    public void setSelectedContract(Contract selectedContract) {
        this.selectedContract = selectedContract;
    }

}

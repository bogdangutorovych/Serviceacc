package ua.com.foxminded.serviceacc.controller.contract;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.enums.ContractStatus;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Named
@ViewScoped
public class ContractListController implements Serializable {

    private static Logger log = LoggerFactory.getLogger(ContractListController.class);
    private static final long serialVersionUID = 1L;

    private List<Contract> list;
    private List<Contract> contractsForInvoices;
    private ContractService contractService;
    private InvoiceService invoiceService;

    public static final int DAYS_TO_CREATE_INVOICE = 5;

    @Inject
    public ContractListController(ContractService contractService, InvoiceService invoiceService) {
        this.contractService = contractService;
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void init() {
        list = contractService.findAll();
        contractsForInvoices = findContractsForInvoiceCreation();
    }

    public void delete(Contract contract) {
        contractService.delete(contract.getId());
        list.remove(contract);
    }

    public List<Contract> findContractsForInvoiceCreation() {
        List<Contract> contractsForInvoiceCreation = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            LocalDate date;
            Contract currentContract = list.get(i);
            Invoice latestInvoice = invoiceService.findMaxDateInvoice(currentContract.getId());
            date = latestInvoice.getPeriod().getDateTo();
            if (currentContract.getCloseDate() == null) {
                currentContract.setCloseDate(LocalDate.MAX);
            }
            if (IsForInvoiceCreation(currentContract, date)) {
                contractsForInvoiceCreation.add(currentContract);
            }
        }
        return contractsForInvoiceCreation;
    }

    public boolean IsForInvoiceCreation(Contract contract, LocalDate invoiceDateTo) {

        return (contract.getContractStatus().equals(ContractStatus.ACTIVE)
                && LocalDate.now().isAfter(invoiceDateTo.plusDays(DAYS_TO_CREATE_INVOICE))
                || ((contract.getContractStatus().equals(ContractStatus.FROZEN)
                        || contract.getContractStatus().equals(ContractStatus.CLOSED))
                        && invoiceDateTo.isBefore(contract.getCloseDate())))
                && contract.getIsTrial() == false;
    }

    public List<Contract> getList() {
        return list;
    }

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    public List<Contract> getContractsForInvoices() {
        return contractsForInvoices;
    }

}

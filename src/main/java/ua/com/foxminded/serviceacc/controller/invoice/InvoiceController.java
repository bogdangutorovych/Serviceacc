package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.enums.InvoiceType;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Named
@ViewScoped
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selected;
    private InvoiceService invoiceService;

    @Inject
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public Invoice prepareForSaving(Contract contract) {
        selected = new Invoice();
        selected.setContract(contract);
        selected.setDate(contract.getContractDate());
        selected.setPeriod(findNextPayPeriod(contract));
        selected.setPrice(contract.getClientRate());
        selected.setInvoiceType(InvoiceType.NEW);
        return selected;
    }

    public void add(Contract contract) {
        if (!contract.getIsTrial()) {
            prepareForSaving(contract);
        }
    }

    public void createInvoiceWithinContractCreation(Contract contract) {
        if (!contract.getIsTrial()) {
            add(contract);
            onOk();
        }
    }

    public Invoice findLatestInvoice(Contract contract) {
        return invoiceService.findMaxDateInvoice(contract.getId());
    }

    public Period findNextPayPeriod(Contract contract) {
        Period nextPayPeriod = new Period();
        Invoice latestInvoice = findLatestInvoice(contract);
        if (latestInvoice == null) {
            nextPayPeriod.setDateFrom(contract.getContractDate());
            nextPayPeriod.setDateTo(nextPayPeriod.getDateFrom().plusMonths(1).minusDays(1));
            return nextPayPeriod;
        }
        nextPayPeriod.setDateFrom(latestInvoice.getPeriod().getDateTo().plusDays(1));
        nextPayPeriod.setDateTo(latestInvoice.getPeriod().getDateTo().plusMonths(1));
        return nextPayPeriod;
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = invoiceService.save(selected);
            selected.setNumber("inv# " + selected.getId());
        }
        invoiceService.save(selected);
    }

    public void clearSelected() {
        selected = null;
    }

    public void onCancel() {
        selected = null;
    }

    public Invoice getSelected() {
        return selected;
    }

    public void setSelected(Invoice selected) {
        this.selected = selected;
    }

    public InvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

}

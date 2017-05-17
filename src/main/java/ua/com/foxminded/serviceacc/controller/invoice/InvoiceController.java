package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.service.ContractService;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Controller
@ViewScoped
@ManagedBean
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selected;

    private InvoiceService invoiceService;
    private ContractService contractService;

    public InvoiceController(InvoiceService invoiceService, ContractService contractService) {
        this.invoiceService = invoiceService;
        this.contractService = contractService;
    }

    public void add() {
        selected = new Invoice();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = invoiceService.create(selected);
        }

        invoiceService.update(selected);
    }

    public void delete() {
        invoiceService.delete(selected.getId());
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

    public ContractService getContractService() {
        return contractService;
    }

    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

}

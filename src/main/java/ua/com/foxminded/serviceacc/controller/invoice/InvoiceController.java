package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
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
    private List<Invoice> list;

    private InvoiceService invoiceService;
    private ContractService contractService;

    public InvoiceController(InvoiceService invoiceService, ContractService contractService) {
        this.invoiceService = invoiceService;
        this.contractService = contractService;
    }

    @PostConstruct
    public void init() {
        list = invoiceService.findAll();
    }

    public void add() {
        selected = new Invoice();
        getActualLists();

    }

    public void getActualLists() {
        // availableClients = contractService.findAll();
        // availableServices = serviceService.findAll();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = invoiceService.create(selected);
        }

        invoiceService.update(selected);
        init();
    }

    public void delete() {
        list.remove(selected);
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

    public List<Invoice> getList() {
        return list;
    }

    public void setList(List<Invoice> list) {
        this.list = list;
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

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
public class InvoiceListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceListController.class);

    private static final long serialVersionUID = 1L;

    private List<Invoice> list;

    private InvoiceService invoiceService;
    private ContractService contractService;

    public InvoiceListController(InvoiceService invoiceService, ContractService contractService) {
        this.invoiceService = invoiceService;
        this.contractService = contractService;
    }

    @PostConstruct
    public void init() {
        list = invoiceService.findAll();
    }

    public void add() {
        getActualLists();

    }

    public void getActualLists() {
        // availableClients = contractService.findAll();
        // availableServices = serviceService.findAll();
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

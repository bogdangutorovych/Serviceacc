package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Controller
@RequestScoped
@ManagedBean
public class InvoiceListController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceListController.class);

    private static final long serialVersionUID = 1L;

    private List<Invoice> list;

    private InvoiceService invoiceService;

    public InvoiceListController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostConstruct
    public void init() {
        list = invoiceService.findAll();
    }

    public List<Invoice> findAllIssuedInvoices(Contract contract) {
        return invoiceService.findInvoicesByContractId(contract.getId());
    }

    public Invoice findLatestInvoice(Contract contract) {
        return invoiceService.findMaxDateInvoice(contract.getId());
    }

    public Period findNextPayPeriod(Contract contract) {
        Invoice latestInvoice = findLatestInvoice(contract);
        if (latestInvoice == null) {
            return null;
        }
        Period nextPayPeriod = new Period();
        nextPayPeriod.setDateFrom(latestInvoice.getPeriod().getDateTo().plusDays(1));
        nextPayPeriod.setDateTo(latestInvoice.getPeriod().getDateTo().plusMonths(1));
        return nextPayPeriod;
    }

    public void delete(Invoice invoice) {
        invoiceService.delete(invoice.getId());
        list.remove(invoice);
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

}

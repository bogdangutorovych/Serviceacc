package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Named
@ViewScoped
@ManagedBean
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selected;
    private Period period;
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void add(Contract contract) {
        init();
        selected.setContract(contract);
        selected.setPeriod(period);
        selected.setPrice(contract.getClientRate());
    }

    public void init() {
        selected = new Invoice();
        period = new Period();
    }

    public void onOk() {
        selected = invoiceService.saveOrUpdate(selected);
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

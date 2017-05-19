package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Controller
@ViewScoped
@ManagedBean
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selected;
    private Period period;
    private Payment payment;
    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void add(Contract contract) {
        init();
        selected.setContract(contract);
        selected.setPeriod(period);
        selected.setPayment(payment);
        selected.setPrice(contract.getClientRate());
    }

    public void init() {
        selected = new Invoice();
        period = new Period();
        payment = new Payment();
    }

    public void onEdit() {
        if (payment == null) {
            payment = new Payment();
        } else {
            selected.setPayment(payment);
        }
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = invoiceService.create(selected);
            selected.setNumber("inv# " + selected.getId());
        }
        invoiceService.update(selected);
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

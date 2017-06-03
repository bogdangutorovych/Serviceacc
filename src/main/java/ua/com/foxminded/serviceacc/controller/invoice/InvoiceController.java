package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;
import java.time.LocalDate;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.enums.InvoiceType;
import ua.com.foxminded.serviceacc.model.enums.PaymentType;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Named
@ViewScoped
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selected;
    private Period period;
    private InvoiceService invoiceService;
    private Payment payment;

    @Inject
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void add(Contract contract) {
        init();
        selected.setContract(contract);
        selected.setPeriod(period);
        selected.setDate(LocalDate.now());
        selected.setPeriod(findNextPayPeriod(contract));
        selected.setPrice(contract.getClientRate());
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

    public void init() {
        selected = new Invoice();
        period = new Period();
        payment = new Payment();
    }

    public void onOk() {
        if (selected.getId() == null) {
            selected = invoiceService.save(selected);
            selected.setNumber("inv# " + selected.getId());
        }
        invoiceService.save(selected);
    }

    public void prepareNewPayment(){
        log.debug("Prepare new Payment");
        payment = new Payment();
    }

    public void addPayment(){
        log.debug("Payment " + payment + " was attached to Invoice " + selected);
        selected.setPayment(payment);
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

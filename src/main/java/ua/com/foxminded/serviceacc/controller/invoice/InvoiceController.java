package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.model.WorkStatement_;
import ua.com.foxminded.serviceacc.model.enums.InvoiceType;
import ua.com.foxminded.serviceacc.service.InvoiceService;

@Named
@ViewScoped
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selectedInvoice;
    private Period period;
    private final InvoiceService invoiceService;
    private Payment payment;
    private WorkStatement newWorkStatement;
    private List<WorkStatement> workStatements;

    @Inject
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public void add(Contract contract) {
        init();
        selectedInvoice.setContract(contract);
        selectedInvoice.setPeriod(period);
        selectedInvoice.setDate(LocalDate.now());
        selectedInvoice.setPeriod(findNextPayPeriod(contract));
        selectedInvoice.setPrice(contract.getClientRate());
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

    @PostConstruct
    public void init() {
        log.debug("init");
        selectedInvoice = new Invoice();
        period = new Period();
        prepareNewPayment();
//        prepareNewWorkStatement();
    }

    public void prepareData(){

    }

    public void onOk() {
        if (selectedInvoice.getId() == null) {
            selectedInvoice = invoiceService.save(selectedInvoice);
            selectedInvoice.setNumber("inv# " + selectedInvoice.getId());
        }
        invoiceService.save(selectedInvoice);
    }

    public void prepareNewPayment(){
        payment = new Payment();
        payment.setMoney(new Money());
        log.debug("Prepared new Payment");
    }

    public void addPayment(){
        selectedInvoice.setPayment(payment);
        selectedInvoice.setInvoiceType(InvoiceType.PAID);
        log.debug("Payment " + payment + " was attached to Invoice " + selectedInvoice);
    }

    public void prepareNewWorkStatement(){
        log.debug("Prepare new WorkStatement");
        newWorkStatement = new WorkStatement();
        newWorkStatement.setInvoice(selectedInvoice);
//        newWorkStatement.setManager(selectedInvoice.getContract().getManager());
    }

    public void addWorkStatement(){
        log.debug("Added WorkStatement: " + newWorkStatement + " to invoice: " + selectedInvoice);
    }

    public void clearSelected() {
        selectedInvoice = null;
    }

    public void onCancel() {
        selectedInvoice = null;
    }

    public Invoice getSelectedInvoice() {
        return selectedInvoice;
    }

    public void setSelectedInvoice(Invoice selectedInvoice) {
        this.selectedInvoice = selectedInvoice;
    }

    public Payment getPayment() {
        return payment;
    }

    public WorkStatement getNewWorkStatement() {
        return newWorkStatement;
    }

}

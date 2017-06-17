package ua.com.foxminded.serviceacc.controller.invoice;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Payment;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.model.enums.InvoiceType;
import ua.com.foxminded.serviceacc.service.InvoiceService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.WorkStatementService;

@Named
@ViewScoped
public class InvoiceController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

    private static final long serialVersionUID = 1L;

    private Invoice selectedInvoice;
    private Period period;
    private final InvoiceService invoiceService;
    private final ManagerService managerService;
    private final WorkStatementService workStatementService;
    private Payment payment;
    private WorkStatement newWorkStatement;
    private List<WorkStatement> workStatements = new ArrayList<>();
    private List<Manager> managers;


    @Inject
    public InvoiceController(InvoiceService invoiceService,
                             ManagerService managerService, WorkStatementService workStatementService) {
        this.invoiceService = invoiceService;
        this.managerService = managerService;
        this.workStatementService = workStatementService;
    }

    public void add(Contract contract) {
//        prepareData();
        selectedInvoice = new Invoice();
        selectedInvoice.setContract(contract);
        selectedInvoice.setPeriod(findNextPayPeriod(contract));
        if (selectedInvoice.getPeriod() == null){
            selectedInvoice.setPeriod(new Period());
        }
        selectedInvoice.setDate(LocalDate.now());
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
        prepareData();
    }

    public void prepareData(){
        log.debug("PrepareData");
        period = new Period();
        prepareNewPayment();
        managers = managerService.findAll();
        if (selectedInvoice != null && selectedInvoice.getId() != null){
            workStatements = workStatementService.findAllByInvoice(selectedInvoice);
        }

    }

    public void onOk() {
        if (selectedInvoice.getId() == null) {
            selectedInvoice = invoiceService.save(selectedInvoice);
            selectedInvoice.setNumber("inv# " + selectedInvoice.getId());
        }
        invoiceService.save(selectedInvoice);
        workStatementService.save(workStatements);
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
        newWorkStatement.setManager(selectedInvoice.getContract().getManager());

        LocalDate invoiceDate = selectedInvoice.getDate();

        newWorkStatement.getPeriod().setDateFrom(invoiceDate);
        newWorkStatement.getPeriod().setDateTo(invoiceDate.plusMonths(1));

        Money clientSpending = new Money();
        clientSpending.setAmount(selectedInvoice.getContract().getClientRate().getAmount());
        clientSpending.setCurrency(selectedInvoice.getContract().getClientRate().getCurrency());
        newWorkStatement.setClientSpending(clientSpending);
        Money managerEaning = new Money();
        managerEaning.setAmount(selectedInvoice.getContract().getManagerRate().getAmount());
        managerEaning.setCurrency(selectedInvoice.getContract().getManagerRate().getCurrency());
        newWorkStatement.setManagerEarning(managerEaning);
    }

    public void addWorkStatement(){
        if (workStatements.size() == 0){
            workStatements.add(newWorkStatement);
        }else if (workStatements.size() == 1){
            WorkStatement first = workStatements.get(0);
            first.getPeriod().setDateTo(newWorkStatement.getPeriod().getDateFrom().minusDays(1));
            first.getManagerEarning().setAmount((calculateManagerRate(selectedInvoice.getPeriod(),
                first.getPeriod(), selectedInvoice.getContract().getManagerRate())));

            newWorkStatement.getManagerEarning().setAmount(
                selectedInvoice.getContract().getManagerRate().getAmount() - first.getManagerEarning().getAmount());
            workStatements.add(newWorkStatement);
        }

        log.debug("Added WorkStatement: " + newWorkStatement + " to invoice: " + selectedInvoice);
    }

    private Long calculateManagerRate(Period invoicePeriod, Period workStPeriod, Money commonRate){

        LocalDate tempDate = LocalDate.from(invoicePeriod.getDateFrom());
        long allDays = tempDate.until(invoicePeriod.getDateTo(), ChronoUnit.DAYS);
        log.debug("AllDays: " + allDays);

        tempDate = LocalDate.from(workStPeriod.getDateFrom());
        long workDays = tempDate.until(workStPeriod.getDateTo(), ChronoUnit.DAYS);
        log.debug("workDays " + workDays);

        double rate = (double) workDays/allDays;
        log.debug("Rate: " + rate);
        log.debug("Amount: " + Double.valueOf(commonRate.getAmount()*rate).longValue());

        return Double.valueOf(commonRate.getAmount()*rate).longValue();
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

    public void setNewWorkStatement(WorkStatement newWorkStatement) {
        this.newWorkStatement = newWorkStatement;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<WorkStatement> getWorkStatements() {
        return workStatements;
    }
}

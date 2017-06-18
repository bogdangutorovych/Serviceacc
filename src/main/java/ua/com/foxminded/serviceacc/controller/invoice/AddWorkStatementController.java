package ua.com.foxminded.serviceacc.controller.invoice;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.foxminded.serviceacc.model.Contract;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.service.InvoiceService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.WorkStatementService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AddWorkStatementController implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(AddWorkStatementController.class);

    private static final long serialVersionUID = 1L;

    private final InvoiceService invoiceService;
    private final WorkStatementService workStatementService;
    private WorkStatement newWorkStatement;

    @Inject
    public AddWorkStatementController(InvoiceService invoiceService, WorkStatementService workStatementService) {
        this.invoiceService = invoiceService;
        this.workStatementService = workStatementService;
    }

    @PostConstruct
    public void init() {
        prepareData();
    }

    public void prepareData(){
        log.debug("PrepareData");

    }

    public void add(Invoice invoice) {
        log.debug("Prepare new WorkStatement for invoice ID: " + invoice.getId() + " date: " + invoice.getDate());

        newWorkStatement = new WorkStatement();
        newWorkStatement.setInvoice(invoice);
        newWorkStatement.setManager(invoice.getContract().getManager());

        newWorkStatement.getPeriod().setDateFrom(invoice.getPeriod().getDateFrom());
        newWorkStatement.getPeriod().setDateTo(invoice.getPeriod().getDateTo());

        Money clientSpending = new Money();
        clientSpending.setAmount(invoice.getContract().getClientRate().getAmount());
        clientSpending.setCurrency(invoice.getContract().getClientRate().getCurrency());
        newWorkStatement.setClientSpending(clientSpending);
        Money managerEarning = new Money();
        managerEarning.setAmount(invoice.getContract().getManagerRate().getAmount());
        managerEarning.setCurrency(invoice.getContract().getManagerRate().getCurrency());
        newWorkStatement.setManagerEarning(managerEarning);
    }

    public WorkStatement getNewWorkStatement() {
        return newWorkStatement;
    }

}

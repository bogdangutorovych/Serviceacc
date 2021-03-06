package ua.com.foxminded.serviceacc.controller.salary;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.service.InvoiceService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.WorkStatementService;

@Named
@ViewScoped
public class WorkStatementController implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(WorkStatementController.class);
    
    private static final long serialVersionUID = 1L;

    private final ManagerService managerService;
    private final InvoiceService invoiceService;
    private final WorkStatementService workStatementService;

    private List<Manager> managers;
    private List<Invoice> invoices;

    private WorkStatement newWorkStatement;
    private List<WorkStatement> workStatements;
    
    @Inject
    public WorkStatementController(ManagerService managerService, InvoiceService invoiceService, 
            WorkStatementService workStatementService) {
        super();
        this.managerService = managerService;
        this.invoiceService = invoiceService;
        this.workStatementService = workStatementService;
    }
    
    @PostConstruct
    public void init() {
        if(!FacesContext.getCurrentInstance().isPostback()) {
            prepareData();
        }
    }

    public void prepareData() {
        managers = managerService.findAll();
        invoices = invoiceService.findAll();

        workStatements = workStatementService.findAllWithInvoice();
        
        newWorkStatement = new WorkStatement();
        newWorkStatement.getManagerEarning().setCurrency(Currency.UAH);
    }

    public void onAdd() {
        newWorkStatement.getClientSpending().setCurrency(
                newWorkStatement.getInvoice().getPrice().getCurrency());
    
        workStatementService.save(newWorkStatement);
        workStatements = workStatementService.findAllWithInvoice();
        
        newWorkStatement = new WorkStatement();
        newWorkStatement.getManagerEarning().setCurrency(Currency.UAH);
    }

    public WorkStatement getNewWorkStatement() {
        return newWorkStatement;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public List<WorkStatement> getWorkStatements() {
        return workStatements;
    }
 
}

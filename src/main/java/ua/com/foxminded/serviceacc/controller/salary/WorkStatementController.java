package ua.com.foxminded.serviceacc.controller.salary;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Period;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.service.InvoiceService;
import ua.com.foxminded.serviceacc.service.ManagerService;
import ua.com.foxminded.serviceacc.service.WorkStatementService;

@Controller
@ViewScoped
@ManagedBean
public class WorkStatementController {
    private static final Logger log = LoggerFactory.getLogger(WorkStatementController.class);

    private List<Manager> managers;
    private List<Invoice> invoices;

    private WorkStatement newWorkStatement;
    private List<WorkStatement> workStatements;

    private ManagerService managerService;
    private InvoiceService invoiceService;
    private WorkStatementService workStatementService;

    public WorkStatementController(ManagerService managerService, InvoiceService invoiceService, 
            WorkStatementService workStatementService) {
        super();
        this.managerService = managerService;
        this.invoiceService = invoiceService;
        this.workStatementService = workStatementService;
    }

    public void prepareData() {
        managers = managerService.findAll();
        invoices = invoiceService.findAll();

        workStatements = workStatementService.findAll();
        
        newWorkStatement = createNewWorkStatement();
    }

    private WorkStatement createNewWorkStatement() {
        WorkStatement workStatement = new WorkStatement();
        workStatement.setPeriod(new Period());
        workStatement.setClientSpending(new Money());
        workStatement.setManagerEarning(new Money());
        workStatement.getManagerEarning().setCurrency(Currency.UAH);
        
        return workStatement;
    }

    public void onAdd() {
        newWorkStatement.getClientSpending().setCurrency(
                newWorkStatement.getInvoice().getPrice().getCurrency());
    
        workStatementService.save(newWorkStatement);
        workStatements = workStatementService.findAll();
        
        newWorkStatement = createNewWorkStatement();
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

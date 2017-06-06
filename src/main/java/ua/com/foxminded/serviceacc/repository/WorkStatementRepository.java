package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.WorkStatement;

public interface WorkStatementRepository extends JpaRepository<WorkStatement, Long>{
    List<WorkStatement> findByManager(Manager manager);
    
    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice "
            + "where workStatement.invoice is not null and "
            + "workStatement.invoice.invoiceType = 'PAID' and "
            + "workStatement.salary is null")
    List<WorkStatement> findPaidNotInSalary();
    
    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice")
    List<WorkStatement> findAllEagerInvoice();
}

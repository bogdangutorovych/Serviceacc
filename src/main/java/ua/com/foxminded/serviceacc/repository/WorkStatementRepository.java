package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.service.dto.PrepareSalaryInfo;

public interface WorkStatementRepository extends JpaRepository<WorkStatement, Long>{
    List<WorkStatement> findByManager(Manager manager);

    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice "
            + "where workStatement.invoice is not null and "
            + "workStatement.invoice.invoiceType = 'PAID' and "
            + "workStatement.salary is null")
    List<WorkStatement> findPaidNotInSalary();

    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice "
            + "where workStatement.invoice is not null and "
            + "workStatement.invoice.invoiceType = 'PAID' and "
            + "workStatement.salary is null and workStatement.manager=?1")
    List<WorkStatement> findByManagerWithPaidInvoicesNotInSalary(Manager manager);

    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice "
            + "where workStatement.invoice is not null and "
            + "workStatement.invoice.invoiceType = 'PAID' and "
            + "workStatement.salary is null and workStatement.manager=?1")
    List<WorkStatement> findPaidNotInSalary(Manager manager);
    
    @Query(value = "select workStatement from WorkStatement workStatement "
            + "join fetch workStatement.invoice")
    List<WorkStatement> findAllWithInvoice();

    @Query(value = "select new ua.com.foxminded.serviceacc.service.dto.PrepareSalaryInfo(manager, count(*) as workStatementCount) "
            + "from WorkStatement workStatement join workStatement.manager manager where workStatement.salary is null group by manager.id")
    public List<PrepareSalaryInfo> findPrepareSalaryInfoList();

    List<WorkStatement> findAllByInvoice(Invoice invoice);
}

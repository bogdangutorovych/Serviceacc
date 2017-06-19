package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ua.com.foxminded.serviceacc.model.Invoice;
import ua.com.foxminded.serviceacc.model.WorkStatement;

public interface WorkStatementService {
    WorkStatement save(WorkStatement workStatement);
    List<WorkStatement> save(List<WorkStatement> workStatements);
    WorkStatement findById(Long id);
    List<WorkStatement> findAll();
    List<WorkStatement> findAllWithInvoice();
    void delete(Long id);
    List<WorkStatement> findAllByInvoice(Invoice invoice);
}

package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import ua.com.foxminded.serviceacc.model.WorkStatement;

public interface WorkStatementService {
    WorkStatement save(WorkStatement workStatement);
    WorkStatement findById(Long id);
    List<WorkStatement> findAll();
    List<WorkStatement> findAllEagerInvoice();
    void delete(Long id);
}

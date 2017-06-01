
package ua.com.foxminded.serviceacc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.repository.WorkStatementRepository;

@Service("workStatementService")
public class WorkStatementServiceDataJpa implements WorkStatementService {
    @Autowired
    WorkStatementRepository workStatementRepository;
    
    @Override
    public WorkStatement save(WorkStatement workStatement) {
        return workStatementRepository.save(workStatement);
    }

    @Override
    public WorkStatement findById(Long id) {
        return workStatementRepository.findOne(id);
    }

    @Override
    public List<WorkStatement> findAll() {
        return workStatementRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        workStatementRepository.delete(id);
    }

    @Override
    public List<WorkStatement> findAllEagerInvoice() {
        return workStatementRepository.findAllEagerInvoice();
    }

}

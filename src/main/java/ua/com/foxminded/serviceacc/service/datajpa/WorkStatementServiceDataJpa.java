
package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.repository.WorkStatementRepository;
import ua.com.foxminded.serviceacc.service.WorkStatementService;

@Service("workStatementService")
public class WorkStatementServiceDataJpa implements WorkStatementService {
    private final WorkStatementRepository workStatementRepository;
    
    @Inject
    public WorkStatementServiceDataJpa(WorkStatementRepository workStatementRepository) {
        super();
        this.workStatementRepository = workStatementRepository;
    }

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
    public List<WorkStatement> findAllWithInvoice() {
        return workStatementRepository.findAllWithInvoice();
    }

}

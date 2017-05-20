package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.WorkStatement;

public interface WorkStatementRepository extends JpaRepository<WorkStatement, Long>{
    List<WorkStatement> findByManager(Manager manager);
}

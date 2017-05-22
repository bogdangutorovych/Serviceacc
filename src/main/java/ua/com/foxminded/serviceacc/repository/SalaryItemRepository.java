package ua.com.foxminded.serviceacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.SalaryItem;

public interface SalaryItemRepository extends JpaRepository<SalaryItem, Long>{
    List<SalaryItem> findByManager(Manager manager);
}

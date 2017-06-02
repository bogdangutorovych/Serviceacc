package ua.com.foxminded.serviceacc.service.datajpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.foxminded.serviceacc.model.Manager;
import ua.com.foxminded.serviceacc.model.Money;
import ua.com.foxminded.serviceacc.model.Salary;
import ua.com.foxminded.serviceacc.model.WorkStatement;
import ua.com.foxminded.serviceacc.model.enums.Currency;
import ua.com.foxminded.serviceacc.repository.SalaryRepository;
import ua.com.foxminded.serviceacc.repository.WorkStatementRepository;
import ua.com.foxminded.serviceacc.service.SalaryService;

@Service("salaryService")
public class SalaryServiceDataJpa implements SalaryService {
    @Autowired
    private WorkStatementRepository workStatementRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Override
    public Salary save(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public Salary findById(Long id) {
        return salaryRepository.findOne(id);
    }

    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        salaryRepository.delete(id);
    }

    public List<Salary> calculateSalaries() {
        List<WorkStatement> workStatements = workStatementRepository.findPaidNotInSalary();

        List<Salary> salaries = sortToSalaries(workStatements);

        salaries = calculateSalaryAmounts(salaries);

        return salaries;
    }

    private List<Salary> sortToSalaries(List<WorkStatement> workStatements) {
        Map<Manager, Salary> salaries = new HashMap<Manager, Salary>();

        for (WorkStatement workStatement : workStatements) {
            if (salaries.containsKey(workStatement.getManager())) {
                Salary salary = salaries.get(workStatement.getManager());
                salary.addWorkStatement(workStatement);
            }
            else {
                Salary salary = new Salary();
                salary.setManager(workStatement.getManager());
                salary.addWorkStatement(workStatement);
                salaries.put(workStatement.getManager(), salary);
            }
        }
        return new ArrayList<Salary>(salaries.values());
    }

    private Money getManagerEarnings(Set <WorkStatement> workStatements) {
        Money money = new Money();
        money.setAmount(0l);
        money.setCurrency(Currency.UAH);

        for (WorkStatement workStatement : workStatements) {
            money.setAmount(Long.sum(money.getAmount(), workStatement.getManagerEarning().getAmount()));
        }

        return money;
    }

    private List<Salary> calculateSalaryAmounts(List<Salary> salaries) {
        for (Salary salary : salaries) {
            Money salaryAmount = getManagerEarnings(salary.getWorkStatements());
            salary.setAmount(salaryAmount);
        }

        return salaries;
    }
}

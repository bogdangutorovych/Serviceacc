package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "salary_id_seq"),
            @Parameter(name = "initial_value", value = "100"), @Parameter(name = "increment_size", value = "50") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "money_id")
    private Money amount;

    @OneToMany(mappedBy = "salary",
            fetch = FetchType.LAZY)
    private Set<WorkStatement> workStatements = new HashSet<>();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public void addWorkStatement(WorkStatement workStatement) {
        workStatements.add(workStatement);
        workStatement.setSalary(this);
    }

    public void removeWorkStatement(WorkStatement workStatement) {
        workStatements.remove(workStatement);
        workStatement.setSalary(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }

    public Set<WorkStatement> getWorkStatements() {
        return workStatements;
    }

    public void setWorkStatements(Set<WorkStatement> workStatements) {
        this.workStatements = workStatements;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}

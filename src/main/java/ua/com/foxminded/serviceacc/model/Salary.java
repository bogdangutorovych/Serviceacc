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
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "money_id")
    private Money amount;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SalaryItem> salaryItems = new HashSet<>();

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Salary() {

    }

    public Salary(Long id, LocalDate date, Manager manager, Money amount, Set<SalaryItem> salaryItems,
            boolean isDeleted) {
        super();
        this.id = id;
        this.date = date;
        this.manager = manager;
        this.amount = amount;
        this.salaryItems = salaryItems;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Set<SalaryItem> getSalaryItems() {
        return salaryItems;
    }

    public void setSalaryItems(Set<SalaryItem> salaryItems) {
        this.salaryItems = salaryItems;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

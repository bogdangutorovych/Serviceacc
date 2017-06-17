package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import ua.com.foxminded.serviceacc.model.enums.ContractStatus;
import ua.com.foxminded.serviceacc.model.enums.ContractType;

@Entity
@Table(name = "contract")
@SQLDelete(sql = "UPDATE contract SET is_deleted = true WHERE id = ?")
@Loader(namedQuery = "findContractById")
@NamedQuery(name = "findContractById", query = "FROM Contract WHERE id = ?1 AND isDeleted = false")
@Where(clause = "is_deleted = false")
public class Contract {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "contract_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "contract_date")
    private LocalDate contractDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "contract_status")
    private ContractStatus contractStatus;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "contract_type")
    private ContractType contractType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_rate")
    private Money clientRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_rate")
    private Money managerRate;

    @Column(name = "is_trial", nullable = false)
    private boolean isTrial;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public LocalDate getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDate closeDate) {
        this.closeDate = closeDate;
    }

    public ContractStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public Money getClientRate() {
        return clientRate;
    }

    public void setClientRate(Money clientRate) {
        this.clientRate = clientRate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Money getManagerRate() {
        return managerRate;
    }

    public void setManagerRate(Money managerRate) {
        this.managerRate = managerRate;
    }

    public boolean getIsTrial() {
        return isTrial;
    }

    public void setIsTrial(boolean isTrial) {
        this.isTrial = isTrial;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}

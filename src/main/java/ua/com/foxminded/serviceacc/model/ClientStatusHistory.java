package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "client_status_history")

@SQLDelete(sql = "UPDATE client_status_history SET active = false WHERE id = ?")
public class ClientStatusHistory {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "client_status_history_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_status_type_id")
    private ContractStatus statusChanged;

    @Column(name = "date_changed")
    private LocalDate dateChanged;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public ClientStatusHistory() {
    }

    public ClientStatusHistory(ContractStatus statusChanged, LocalDate dateChanged) {

        this.statusChanged = statusChanged;
        this.dateChanged = dateChanged;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContractStatus getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(ContractStatus statusChanged) {
        this.statusChanged = statusChanged;
    }

    public LocalDate getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(LocalDate dateChanged) {
        this.dateChanged = dateChanged;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
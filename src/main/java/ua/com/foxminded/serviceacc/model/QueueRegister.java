package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "queue_register")
@SQLDelete(sql = "UPDATE queue_register SET is_deleted = true WHERE id = ?")
@Loader(namedQuery = "findQueueRegisterById")
@NamedQuery(name = "findQueueRegisterById", query = "FROM QueueRegister WHERE id = ?1 AND isDeleted = false")
@Where(clause = "is_deleted = false")
public class QueueRegister {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "queue_register_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @Column(name = "after_freezing", nullable = false)
    private boolean afterFreezing;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public boolean isAfterFreezing() {
        return afterFreezing;
    }

    public void setAfterFreezing(boolean afterFreezing) {
        this.afterFreezing = afterFreezing;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}

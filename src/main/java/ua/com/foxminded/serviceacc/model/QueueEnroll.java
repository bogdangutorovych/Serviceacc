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
@Table(name = "queue_enroll")
@SQLDelete(sql = "UPDATE queue_enroll SET is_deleted = true WHERE id = ?")
public class QueueEnroll {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "queue_enroll_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "queue_enroll_date")
    private LocalDate dateEnroll;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deal_id")
    private Deal deal;

    @Column(name = "novice", nullable = false)
    private boolean novice;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public QueueEnroll() {

    }

    public QueueEnroll(LocalDate queueEnrollDate, Deal deal, boolean novice) {
        this.dateEnroll = queueEnrollDate;
        this.deal = deal;
        this.novice = novice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateEnroll() {
        return dateEnroll;
    }

    public void setDateEnroll(LocalDate dateEnroll) {
        this.dateEnroll = dateEnroll;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public boolean isNovice() {
        return novice;
    }

    public void setNovice(boolean novice) {
        this.novice = novice;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

}

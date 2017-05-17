package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ua.com.foxminded.serviceacc.model.enums.PaymentType;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "payment_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "money_id")
    private Money money;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "payment_type")
    private PaymentType paymentType;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Payment() {

    }

    public Payment(Long id, LocalDate date, Money money, PaymentType type, boolean isDeleted) {
        super();
        this.id = id;
        this.date = date;
        this.money = money;
        this.paymentType = type;
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

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public PaymentType getType() {
        return paymentType;
    }

    public void setType(PaymentType type) {
        this.paymentType = type;
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

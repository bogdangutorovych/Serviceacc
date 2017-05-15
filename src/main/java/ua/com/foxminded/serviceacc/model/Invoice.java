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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ua.com.foxminded.serviceacc.model.enums.InvoiceType;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "invoice_id_seq"),
            @Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "money_id")
    private Money price;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "invoice_type")
    private InvoiceType invoiceType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "period_id")
    private Period period;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    public Invoice(Long id, String number, LocalDate date, Contract contract, Money price, InvoiceType invoiceType,
            Payment payment, Period period, boolean isDeleted) {
        super();
        this.id = id;
        this.number = number;
        this.date = date;
        this.contract = contract;
        this.price = price;
        this.invoiceType = invoiceType;
        this.payment = payment;
        this.period = period;
        this.isDeleted = isDeleted;
    }

    public Invoice() {
    }

}

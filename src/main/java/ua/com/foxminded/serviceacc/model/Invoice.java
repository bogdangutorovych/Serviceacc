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
import javax.persistence.OneToOne;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "money_id")
    private Money price;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "invoice_type")
    private InvoiceType invoiceType;

    @OneToOne(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToOne(fetch = FetchType.EAGER, cascade = javax.persistence.CascadeType.ALL)
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

    public Long getId() {
        return id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}

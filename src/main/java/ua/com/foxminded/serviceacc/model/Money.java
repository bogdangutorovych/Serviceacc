package ua.com.foxminded.serviceacc.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ua.com.foxminded.serviceacc.model.enums.CurrencyType;

@Entity
@Table(name = "money")
@SQLDelete(sql = "UPDATE money SET active = false WHERE id = ?")
@Loader(namedQuery = "findMoneyById")
@NamedQuery(name = "findMoneyById", query = "FROM Money WHERE id = ?1 AND active = true")
@Where(clause = "active = true")
public class Money {

    @Id
    @GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "money_id_seq"), @Parameter(name = "initial_value", value = "1"),
            @Parameter(name = "increment_size", value = "1") })
    @GeneratedValue(generator = "generator")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private CurrencyType currency;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Money() {
    }

    public Money(CurrencyType currency, Long amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (currency != money.currency) return false;
        return amount != null ? amount.equals(money.amount) : money.amount == null;

    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}

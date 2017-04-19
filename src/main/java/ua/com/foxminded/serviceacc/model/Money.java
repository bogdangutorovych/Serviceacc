package ua.com.foxminded.serviceacc.model;

import java.util.Currency;

import javax.persistence.*;

@Entity
@Table(name = "money")
public class Money {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "money_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "currency")
	private Currency currency;

	@Column(name = "amount")
	private int amount;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Money() {
	}

	public Money(Currency currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

package ua.com.foxminded.serviceacc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "payment_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "money_id")
	private Money money;
	
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "paymentType_id")
	private PaymentType type;

	@Column(name = "active", nullable = false)
	private boolean active = true;
	
	public Payment() {

	}

	public Payment(Date date, Money money, PaymentType type) {
		this.date = date;
		this.money = money;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public PaymentType getType() {
		return type;
	}

	public void setType(PaymentType type) {
		this.type = type;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

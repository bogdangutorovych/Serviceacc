package ua.com.foxminded.serviceacc.model;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
	
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "money_id")
	private Money price;
	
	@ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "serviceType_id")
	private ServiceType type;
	
	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Service() {

	}

	public Service(String name, Money price, ServiceType type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public ServiceType getType() {
		return type;
	}

	public void setType(ServiceType type) {
		this.type = type;
	}

}

package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "contract")
public class Contract {

	@Id
	@GenericGenerator(name = "generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "contract_id_seq"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "date")
	private LocalDate date;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id")
	private Client client;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id")
	private Service service;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_rate")
	private Money clientRate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_rate")
	private Money managerRate;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Contract() {

	}

	public Contract(String number, LocalDate date, Client client, Manager manager, Service service, Money clientRate,
			Money managerRate) {
		this.number = number;
		this.date = date;
		this.client = client;
		this.manager = manager;
		this.service = service;
		this.clientRate = clientRate;
		this.managerRate = managerRate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Money getClientRate() {
		return clientRate;
	}

	public void setClientRate(Money clientRate) {
		this.clientRate = clientRate;
	}

	public Money getManagerRate() {
		return managerRate;
	}

	public void setManagerRate(Money managerRate) {
		this.managerRate = managerRate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "contract_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "number")
	private String number;

	@Column(name = "contract_date")
	private LocalDate date;

	@OneToOne(fetch = FetchType.EAGER)
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

	public LocalDate getLocalDate() {
		return date;
	}

	public void setLocalDate(LocalDate date) {
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

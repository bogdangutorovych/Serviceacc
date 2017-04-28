package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "contract")
@SQLDelete(sql = "UPDATE contract SET active = false WHERE id = ?")
@Loader(namedQuery = "findContractById")
@NamedQuery(name = "findContractById", query = "FROM Contract WHERE id = ?1 AND active = true")
@Where(clause = "active = true")
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

	@Column(name = "contract_date")
	private LocalDate contractDate;

	@Column(name = "payment_date")
	private LocalDate paymentDate;

	@Column(name = "close_date")
	private LocalDate closeDate;

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
	@JoinColumn(name = "contract_status_id")
	private ContractStatus contractStatus;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_rate")
	private Money clientRate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_rate")
	private Money managerRate;

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public LocalDate getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDate closeDate) {
		this.closeDate = closeDate;
	}

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Contract() {

	}

	public Contract(String number, LocalDate date, Client client, Manager manager, Service service,
			ContractStatus contractStatus, Money clientRate, Money managerRate) {
		this.number = number;
		this.contractDate = date;
		this.client = client;
		this.manager = manager;
		this.service = service;
		this.clientRate = clientRate;
		this.managerRate = managerRate;
		this.contractStatus = contractStatus;
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

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
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

	public ContractStatus getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(ContractStatus contractStatus) {
		this.contractStatus = contractStatus;
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

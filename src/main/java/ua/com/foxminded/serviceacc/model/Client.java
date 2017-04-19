package ua.com.foxminded.serviceacc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "client")

@SQLDelete(sql = "UPDATE client SET active = false WHERE id = ?")
@Loader(namedQuery = "findOne")
@NamedQuery(name = "findOne", query = "FROM Client WHERE id = ?1 AND active = true")
@Where(clause = "active = true")

public class Client {
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_day")
	private Date birthday;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_level_type_id")
	private ClientLevelType level;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_status_type_id")
	private ClientStatusType status;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "client_id", referencedColumnName = "id", updatable = false)
	private Set<ClientInformation> informations = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "client_id", referencedColumnName = "id", updatable = false)
	private Set<ClientStatusHistory> clientHistory = new HashSet<>();

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Client() {
	}

	public Client(String firstName, String lastName, Date birthday, Manager manager, ClientLevelType level,
			ClientStatusType status, Set<ClientInformation> informations, Set<ClientStatusHistory> clientHistory,
			boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.manager = manager;
		this.level = level;
		this.status = status;
		this.informations = informations;
		this.clientHistory = clientHistory;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ClientLevelType getLevel() {
		return level;
	}

	public void setLevel(ClientLevelType level) {
		this.level = level;
	}

	public ClientStatusType getStatus() {
		return status;
	}

	public void setStatus(ClientStatusType status) {
		this.status = status;
	}

	public Set<ClientInformation> getInformations() {
		return informations;
	}

	public void setInformations(Set<ClientInformation> informations) {
		this.informations = informations;
	}

	public Set<ClientStatusHistory> getClientHistory() {
		return clientHistory;
	}

	public void setClientHistory(Set<ClientStatusHistory> clientHistory) {
		this.clientHistory = clientHistory;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
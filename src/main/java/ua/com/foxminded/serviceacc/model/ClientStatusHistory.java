package ua.com.foxminded.serviceacc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "client_status_history")

@SQLDelete(sql = "UPDATE client_status_history SET active = false WHERE client_id = ?")

@Loader(namedQuery = "findByClient")

@NamedQuery(name = "findByClient", query = "FROM ClientStatusHistory WHERE id = ?1 AND active = true")

@Where(clause = "active = true")

public class ClientStatusHistory {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_status_history_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_status_type_id")
	private ClientStatusType statusChanged;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_changed")
	private Date dateChanged;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public ClientStatusHistory() {
	}

	public ClientStatusHistory(Client client, ClientStatusType statusChanged, Date dateChanged) {
		this.client = client;
		this.statusChanged = statusChanged;
		this.dateChanged = dateChanged;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientStatusType getStatusChanged() {
		return statusChanged;
	}

	public void setStatusChanged(ClientStatusType statusChanged) {
		this.statusChanged = statusChanged;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
package ua.com.foxminded.serviceacc.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "client_status_history")

@SQLDelete(sql = "UPDATE client_status_history SET active = false WHERE id = ?")
public class ClientStatusHistory {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_status_history_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

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

	public ClientStatusHistory(ClientStatusType statusChanged, Date dateChanged) {

		this.statusChanged = statusChanged;
		this.dateChanged = dateChanged;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
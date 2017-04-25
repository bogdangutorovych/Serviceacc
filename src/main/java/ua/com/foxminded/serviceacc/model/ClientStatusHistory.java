package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;

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

	@Column(name = "date_changed")
	private LocalDate dateChanged;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public ClientStatusHistory() {
	}

	public ClientStatusHistory(ClientStatusType statusChanged, LocalDate dateChanged) {

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

	public LocalDate getLocalDateChanged() {
		return dateChanged;
	}

	public void setLocalDateChanged(LocalDate dateChanged) {
		this.dateChanged = dateChanged;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
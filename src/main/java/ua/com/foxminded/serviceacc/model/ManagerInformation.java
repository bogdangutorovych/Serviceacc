package ua.com.foxminded.serviceacc.model;

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

@Entity
@Table(name = "manager_info")
public class ManagerInformation {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "manager_info_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "content")
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "info_type_id")
	private ManagerInformationType informationType;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public ManagerInformation() {
	}

	public ManagerInformation(String content, ManagerInformationType informationType, boolean active) {

		this.content = content;
		this.informationType = informationType;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ManagerInformationType getInformationType() {
		return informationType;
	}

	public void setInformationType(ManagerInformationType informationType) {
		this.informationType = informationType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
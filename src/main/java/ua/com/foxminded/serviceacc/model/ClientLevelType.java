package ua.com.foxminded.serviceacc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by andreb on 04.04.17. Class represent client graduate level
 */
@Entity
@Table(name = "client_level_type")
public class ClientLevelType {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_level_type_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "title", unique = true, nullable = false)
	private String title;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "level", orphanRemoval = true)
	private Set<Client> clients = new HashSet<>();

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public ClientLevelType() {
	}

	public ClientLevelType(String code, String level) {
		this.code = code;
		this.title = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String level) {
		this.title = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
}

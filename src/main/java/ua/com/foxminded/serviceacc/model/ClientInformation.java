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

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "client_info")

@SQLDelete(sql = "UPDATE client_info SET active = false WHERE client_info_id = ?")

@Loader(namedQuery = "findClientInformationByClientId")

@NamedQuery(name = "findClientInformationByClientId", query = "FROM ClientInformation WHERE id = ?1 AND active = true")

@Where(clause = "active = true")

public class ClientInformation {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "client_info_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "client_info_id", unique = true, nullable = false)
	private Long id;

	@Column(name = "content")
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "info_type_id")
	private ClientInformationType clientInformationType;

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public ClientInformation() {
	}

	public ClientInformation(String content, ClientInformationType clientInformationType, boolean active) {

		this.content = content;
		this.clientInformationType = clientInformationType;
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

	public ClientInformationType getClientInformationType() {
		return clientInformationType;
	}

	public void setClientInformationType(ClientInformationType clientInformationType) {
		this.clientInformationType = clientInformationType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		ClientInformation that = (ClientInformation) o;

		return id != null ? id.equals(that.id) : that.id == null;

	}

	@Override
	public String toString() {
		return "ClientInformation{" + "id=" + id + ", content='" + content + '\'' + ", clientInformationType="
				+ clientInformationType + '}';
	}
}
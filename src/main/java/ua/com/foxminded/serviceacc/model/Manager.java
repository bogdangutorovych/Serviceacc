package ua.com.foxminded.serviceacc.model;

import java.time.LocalDate;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "manager")

@SQLDelete(sql = "UPDATE manager SET active = false WHERE id = ?")
@Loader(namedQuery = "findManagerById")
@NamedQuery(name = "findManagerById", query = "FROM Manager WHERE id = ?1 AND active = true")
@Where(clause = "active = true")

public class Manager {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "manager_id_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "birth_day")
	private LocalDate birthday;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id", referencedColumnName = "id")
	private Set<ManagerInformation> informations = new HashSet<>();

	@Column(name = "active", nullable = false)
	private boolean active = true;

	public Manager() {

	}

	public Manager(String firstName, String lastName, LocalDate birthday, Set<ManagerInformation> informations,
			Set<Client> clients, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.informations = informations;
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Set<ManagerInformation> getInformations() {
		return informations;
	}

	public void setInformations(Set<ManagerInformation> informations) {
		this.informations = informations;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
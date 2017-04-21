package ua.com.foxminded.serviceacc.model;

import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "currency_type")
public class CurrencyType {

	@Id
	@SequenceGenerator(name = "generator", sequenceName = "currency_type_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(name = "code", unique = true, nullable = false)
	private String code;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "active", nullable = false)
	private boolean active = true;

	public CurrencyType() {
	}

	public CurrencyType(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}
